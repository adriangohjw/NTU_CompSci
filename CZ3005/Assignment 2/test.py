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
        learned_value = reward + (self.discount * self.__get_max_Q_values(next_state))
        self.Q[state][action_index] = ((1 - self.learning_rate) * old_value) + (self.learning_rate * learned_value)

    def __get_action_index(self, action):
        if action not in self.action_space:
            pass
        return self.action_space.index(action)

    def __get_max_Q_values(self, state):
        return max(self.Q[state])
        
    def round_up_Q_values(self, num_of_dp):
        for key, values in self.Q.items():
            for index in range(len(values)):
                self.Q[key][index] = round(values[index], num_of_dp)


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

if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Test')
    parser.add_argument('--max_episode', type=int, default=500)
    parser.add_argument('--max_step', type=int, default=500)
    args = parser.parse_args()

    test_cube(args.max_episode, args.max_step)
