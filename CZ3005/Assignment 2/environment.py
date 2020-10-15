import numpy as np
import time
import random

from abc import ABC, abstractmethod


class AbstractEnvironment(ABC):
    def __init__(self):
        self.agent_sign = '+'
        self.goal_sign = 'G'
        self.corridor_sign = '-'

    def render(self):
        raise NotImplemented

    def reset(self):
        raise NotImplemented

    def step(self, action):
        raise NotImplemented

class TreasureCube(AbstractEnvironment):
    def __init__(self, max_step=20):
        super(TreasureCube, self).__init__()
        self.dim = 4
        self.max_step = max_step
        self.curr_pos = [0, 0, 0]  # (z, x, y)
        self.time_step = 0
        self.end_pos = [self.dim - 1, self.dim - 1, self.dim - 1]
        self.visual_state = []
        self.seed = None
        self.set_seed()
        self.all_actions = ['right', 'left', 'up', 'down', 'forward', 'backward']
        self.slip_actions = dict()
        self.set_action_rules()

    def reset(self):
        self.curr_pos = [0, 0, 0]
        self.time_step = 0
        self.end_pos = [self.dim - 1, self.dim - 1, self.dim - 1]
        self._reset_visual_states(self.curr_pos, self.end_pos)
        return ''.join(str(pos) for pos in self.curr_pos)

    def step(self, action, stochastic=True):
        in_action = action  # action from agent
        assert action in self.all_actions
        reward = -0.1
        is_terminate = False
        pre_pos = self.curr_pos
        r = random.random()
        if action == 'right':
            if r < 0.1:
                action = 'up'
            elif r < 0.2:
                action = 'down'
            elif r < 0.3:
                action = 'forward'
            elif r < 0.4:
                action = 'backward'
            else:
                action = 'right'
        elif action == 'left':
            if r < 0.1:
                action = 'up'
            elif r < 0.2:
                action = 'down'
            elif r < 0.3:
                action = 'forward'
            elif r < 0.4:
                action = 'backward'
            else:
                action = 'left'
        elif action == 'up':
            if r < 0.1:
                action = 'left'
            elif r < 0.2:
                action = 'right'
            elif r < 0.3:
                action = 'forward'
            elif r < 0.4:
                action = 'backward'
            else:
                action = 'up'
        elif action == 'down':
            if r < 0.1:
                action = 'left'
            elif r < 0.2:
                action = 'right'
            elif r < 0.3:
                action = 'forward'
            elif r < 0.4:
                action = 'backward'
            else:
                action = 'down'
        elif action == 'forward':
            if r < 0.1:
                action = 'left'
            elif r < 0.2:
                action = 'right'
            elif r < 0.3:
                action = 'up'
            elif r < 0.4:
                action = 'down'
            else:
                action = 'forward'
        else:
            if r < 0.1:
                action = 'left'
            elif r < 0.2:
                action = 'right'
            elif r < 0.3:
                action = 'up'
            elif r < 0.4:
                action = 'down'
            else:
                action = 'backward'

        if not stochastic:
            action = in_action

        assert action in self.all_actions
        if action == 'left':
            if self.curr_pos[1] == 0:  # wall
                pass
            else:
                self.curr_pos[1] -= 1
        elif action == 'right':
            if self.curr_pos[1] == self.dim - 1:  # wall
                pass
            elif self.curr_pos[1] == self.dim - 2 and self.curr_pos[0] == self.dim - 1 and self.curr_pos[
                2] == self.dim - 1:
                self.curr_pos[1] += 1
                is_terminate = True
                reward = 1
            else:
                self.curr_pos[1] += 1

        elif action == 'forward':
            if self.curr_pos[0] == self.dim - 1:  # wall
                pass
            elif self.curr_pos[0] == self.dim - 2 and self.curr_pos[1] == self.dim - 1 and self.curr_pos[
                2] == self.dim - 1:
                self.curr_pos[0] += 1
                is_terminate = True
                reward = 1
            else:
                self.curr_pos[0] += 1
        elif action == 'backward':
            if self.curr_pos[0] == 0:  # wall
                pass
            else:
                self.curr_pos[0] -= 1

        elif action == 'up':
            if self.curr_pos[2] == self.dim - 1:  # wall
                pass
            elif self.curr_pos[2] == self.dim - 2 and self.curr_pos[0] == self.dim - 1 and self.curr_pos[
                1] == self.dim - 1:
                self.curr_pos[2] += 1
                is_terminate = True
                reward = 1
            else:
                self.curr_pos[2] += 1
        elif action == 'down':
            if self.curr_pos[2] == 0:
                pass
            else:
                self.curr_pos[2] -= 1

        assert action in self.all_actions
        self.time_step += 1
        if self.time_step == self.max_step - 1:
            is_terminate = True

        self._reset_visual_states(self.curr_pos, self.end_pos)
        return reward, is_terminate, ''.join(str(pos) for pos in self.curr_pos)

    def render(self):
        print(' '.join(['*'] * self.dim))
        for i in range(self.dim):
            for line in self.visual_state[i]:
                print(' '.join(line))
            print(' '.join(['#'] * self.dim))
        print(' '.join(['*'] * self.dim))

    def set_seed(self, seed=10086):
        self.seed = seed
        random.seed(seed)

    def _reset_visual_states(self, agent_pos, goal_pos):
        self.visual_state = [[[self.corridor_sign] * self.dim for _ in range(self.dim)] for _ in range(self.dim)]
        self.visual_state[agent_pos[0]][agent_pos[1]][agent_pos[2]] = self.agent_sign
        self.visual_state[goal_pos[0]][goal_pos[1]][goal_pos[2]] = self.goal_sign

    def set_action_rules(self):
        self.slip_actions['right'] = ['up', 'down', 'forward', 'backward', 'right']
        self.slip_actions['left'] = ['up', 'down', 'forward', 'backward', 'left']
        self.slip_actions['up'] = ['left', 'right', 'forward', 'backward', 'up']
        self.slip_actions['down'] = ['left', 'right', 'forward', 'backward', 'down']
        self.slip_actions['forward'] = ['left', 'right', 'up', 'down', 'forward']
        self.slip_actions['backward'] = ['left', 'right', 'up', 'down', 'backward']

