from collections import defaultdict
import argparse
import random
import numpy as np
from environment import TreasureCube
from pprint import pprint


# you need to implement your agent based on one RL algorithm
class RandomAgent(object):
    def __init__(self):
        self.action_space = ['left','right','forward','backward','up','down'] # in TreasureCube
        self.Q = defaultdict(lambda: np.zeros(len(self.action_space)))
        self.discount = 0.99
        self.learning_rate = 0.5
        self.exploration_rate = 0.01

    # added exploration or exploitation
    def take_action(self, state):
        if random.random() > self.exploration_rate:
            return self.__exploit(state)
        else:
            return self.__explore()
    
    def __exploit(self, state):
        action_index_with_largest_q_value = np.argmax(self.Q[state])
        return self.action_space[action_index_with_largest_q_value]

    def __explore(self):
        return random.choice(self.action_space)


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
        return max(self.Q[state])
        
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
        next_state = current_state
        print(f"Starting state: {current_state}")

        actions_counter = 0
        solution_found = False
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

            print(f"Moving from {current_state} to {next_state} with action '{action_to_take}'")
            current_state = next_state
            actions_counter += 1

            if next_state == '333':
                solution_found = True

        print(f'Number of steps taken: {actions_counter}')
        if solution_found:
            print("Solution found")
        else:
            print("Solution not found")


def test_cube(max_episode, max_step):
    env = TreasureCube(max_step=max_step)
    agent = RandomAgent()

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
        print(f'epsisode: {epsisode_num}, total_steps: {t} episode reward: {episode_reward}')

    agent.round_up_Q_values(num_of_dp=3)
    pprint(dict(agent.Q))

    print()
    agent.find_optimal_path(current_state='000', max_steps=(3*(env.dim-1)))


if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Test')
    parser.add_argument('--max_episode', type=int, default=500)
    parser.add_argument('--max_step', type=int, default=500)
    args = parser.parse_args()

    test_cube(args.max_episode, args.max_step)
