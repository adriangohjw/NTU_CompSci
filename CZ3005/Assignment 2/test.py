from collections import defaultdict
import argparse
import random
import numpy as np
from environment import TreasureCube
from pprint import pprint
import csv
import matplotlib.pyplot as plt
import time


# you need to implement your agent based on one RL algorithm
class RandomAgent(object):
    def __init__(self, dimension):
        self.action_space = ['left','right','forward','backward','up','down'] # in TreasureCube
        self.Q = defaultdict(lambda: np.zeros(len(self.action_space)))
        self.discount = 0.99
        self.learning_rate = 0.5
        self.exploration_rate = 0.01
        self.dimension = dimension

        for x in range(self.dimension):
            for y in range(self.dimension):
                for z in range(self.dimension):
                    state = str(x) + str(y) + str(z)
                    if str(x) == '0':
                        self.Q[state][self.action_space.index("backward")] = -99
                    if str(x) == '3':
                        self.Q[state][self.action_space.index("forward")] = -99
                    if str(y) == '0':
                        self.Q[state][self.action_space.index("left")] = -99
                    if str(y) == '3':
                        self.Q[state][self.action_space.index("right")] = -99
                    if str(z) == '0':
                        self.Q[state][self.action_space.index("down")] = -99
                    if str(z) == '3':
                        self.Q[state][self.action_space.index("up")] = -99

    # added exploration or exploitation
    def take_action(self, state):
        if random.random() > self.exploration_rate:
            return self.__exploit(state)
        else:
            return self.__explore(state)
    
    def __exploit(self, state):
        state = str(state)
        x, y, z = state[0], state[1], state[2]

        q_values = self.Q[state]
        q_values = np.ma.array(q_values, mask=False)
        if x == "0":
            q_values.mask[self.action_space.index("backward")] = True 
        elif x == "3":
            q_values.mask[self.action_space.index("forward")] = True 
        if y == "0":
            q_values.mask[self.action_space.index("left")] = True 
        elif y == "3":
            q_values.mask[self.action_space.index("right")] = True 
        if z == "0":
            q_values.mask[self.action_space.index("down")] = True 
        elif z == "3":
            q_values.mask[self.action_space.index("up")] = True

        action_index_with_largest_q_value = np.argmax(q_values)
        return self.action_space[action_index_with_largest_q_value]

    def __explore(self, state):
        state = str(state)
        x, y, z = state[0], state[1], state[2]

        available_actions = self.action_space.copy()
        if x == "0":
            available_actions.remove("backward")
        elif x == "3":
            available_actions.remove("forward")
        if y == "0":
            available_actions.remove("left")
        elif y == "3":
            available_actions.remove("right")
        if z == "0":
            available_actions.remove("down")
        elif z == "3":
            available_actions.remove("up")

        return random.choice(available_actions)


    # implement your train/update function to update self.V or self.Q
    # you should pass arguments to the train function
    def train(self, state, action, next_state, reward):
        action_index = self.__get_action_index(action)
        old_value = self.Q[state][action_index]
        learned_value = reward + (self.discount * self.__get_max_Q_value(next_state))
        self.Q[state][action_index] = ((1 - self.learning_rate) * old_value) + (self.learning_rate * learned_value)

    def __get_action_index(self, action):
        if action not in self.action_space:
            pass
        return self.action_space.index(action)

    def __get_max_Q_value(self, state): 
        state = str(state)

        available_action_index = [i for i in range(len(self.action_space))]
        if state[0] == "0":
            available_action_index.remove(self.action_space.index("backward"))
        if state[0] == "3":
            available_action_index.remove(self.action_space.index("forward"))
        if state[1] == "0":
            available_action_index.remove(self.action_space.index("left"))
        if state[1] == "3":
            available_action_index.remove(self.action_space.index("right"))
        if state[2] == "0":
            available_action_index.remove(self.action_space.index("down"))
        if state[2] == "3":
            available_action_index.remove(self.action_space.index("up"))

        available_q_values = [self.Q[state][index] for index in available_action_index]

        return max(available_q_values)
        
    def round_up_Q_values(self, num_of_dp):
        for key, values in self.Q.items():
            for index in range(len(values)):
                self.Q[key][index] = round(values[index], num_of_dp)


    def find_optimal_path(self, current_state, max_steps=9, goal_state='333'):
        """
        # Find the optimal path to the goal state based on current state and agent's Q values

        # Assumption for default values for params: Cube is 4x4 dimension
        :param current_state: current coordinate of the current state in the format of 'xyz'
        :param max_steps: Max number of steps that agent can take - needed to break out of infinite loop if no optimal solution found
        :param goal_state: coordinate of the goal state in the format of 'xyz'
        """
        current_state = str(current_state) if current_state != 0 else '000'
        initial_state = current_state
        next_state = current_state

        actions_counter = 0
        solution_found = False

        if initial_state == goal_state:
            solution_found = True

        while current_state != str(goal_state) and actions_counter < max_steps:

            # determine best action to take
            action_index_with_largest_q_value = np.argmax(self.Q[current_state])
            action_to_take = self.action_space[action_index_with_largest_q_value]

            # move to the next state
            if action_to_take == "left":
                if current_state[1] == '0':
                    pass
                else:
                    next_state = current_state[0] + str(int(current_state[1]) - 1) + current_state[2]

            elif action_to_take == "right":
                if current_state[1] == '3':
                    pass
                else:
                    next_state = current_state[0] + str(int(current_state[1]) + 1) + current_state[2]

            elif action_to_take == "forward":
                if current_state[0] == '3':
                    pass
                else:
                    next_state = str(int(current_state[0]) + 1) + current_state[1:]

            elif action_to_take == "backward":
                if current_state[0] == '0':
                    pass
                else:
                    next_state = str(int(current_state[0]) - 1) + current_state[1:]

            elif action_to_take == "up":
                if current_state[2] == '3':
                    pass
                else:
                    next_state = current_state[:2] + str(int(current_state[2]) + 1)

            elif action_to_take == "down":
                if current_state[2] == '0':
                    pass
                else:
                    next_state = current_state[:2] + str(int(current_state[2]) - 1)

            else:
                break

            print(f'--- moving from {current_state} to {next_state}: {action_to_take}')

            current_state = next_state
            actions_counter += 1

            if next_state == '333':
                solution_found = True

        optimal_path_action_count = (int(goal_state[0]) - int(initial_state[0])) + (int(goal_state[1]) - int(initial_state[1])) + (int(goal_state[2]) - int(initial_state[2]))
        if solution_found and (optimal_path_action_count == actions_counter):
            print(f'State {initial_state} test ✔️')
            print()
            return True
        else:
            print(f'State {initial_state} test ❌')
            print()
            return False    


def test_cube(max_episode, max_step):
    env = TreasureCube(max_step=max_step)
    agent = RandomAgent(dimension=env.dim)
    episode_rewards_list = []

    for epsisode_num in range(0, max_episode):
        state = env.reset()
        terminate = False
        t = 0
        episode_reward = 0
        while not terminate:
            action = agent.take_action(state)
            reward, terminate, next_state = env.step(action)
            episode_reward += reward
            # you can comment the following two lines, if the output is too much
            # env.render() # comment
            # print(f'step: {t}, action: {action}, reward: {reward}') # comment
            t += 1
            agent.train(state, action, next_state, reward)
            state = next_state
        #print(f'epsisode: {epsisode_num}, total_steps: {t} episode reward: {episode_reward}')
        episode_rewards_list.append(episode_reward)

    agent.round_up_Q_values(num_of_dp=3)
    pprint(dict(agent.Q))

    print()
    run_test(agent, env)

    print()
    export_Q_table_to_csv(agent)

    print()
    plot_learning_progress(max_step=max_step, episode_rewards_list=episode_rewards_list)


def run_test(agent, env):
    total_tests = pow(env.dim, 3)
    total_test_passed = 0
    for x in range(env.dim):
        for y in range(env.dim):
            for z in range(env.dim):
                current_state = str(x) + str(y) + str(z)
                is_path_optimal = agent.find_optimal_path(current_state=current_state)
                if is_path_optimal:
                    total_test_passed += 1 
    print(f'Total tests passed: {total_test_passed} out of {total_tests}')


def export_Q_table_to_csv(agent, csv_file_name="Q_table.csv"):
    q_table_dict = agent.Q
    q_table_list = list(dict(agent.Q).keys())
    q_table_list.sort()
    
    with open(csv_file_name, 'w', newline='') as file:
        file_writer = csv.writer(file, delimiter=",")
        file_writer.writerow(["state"] + agent.action_space)

        for state in q_table_list:
            row_data = [state]
            values = agent.Q[state]
            for index in range(len(values)):
                row_data.append(str(values[index]))
            file_writer.writerow(row_data)

    print("File exported!")


def plot_learning_progress(max_step, episode_rewards_list):
    Range = [i for i in range(len(episode_rewards_list))]
    plt.plot(Range, episode_rewards_list, label=f'max_step={max_step}')
    plt.suptitle("Learning Progress")
    plt.xlabel("Episodes")
    plt.ylabel("Episode rewards")
    ax = plt.gca()
    plt.legend()
    plt.savefig("learning_progress.png")


if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Test')
    parser.add_argument('--max_episode', type=int, default=500)
    parser.add_argument('--max_step', type=int, default=500)
    args = parser.parse_args()

    start_time = time.perf_counter()
    test_cube(args.max_episode, args.max_step)
    end_time = time.perf_counter()
    print(f"Program completed in {end_time - start_time:0.4f} seconds")
