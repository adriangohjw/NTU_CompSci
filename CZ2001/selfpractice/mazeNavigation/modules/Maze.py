class Maze:

    def __init__(self, x=0, y=0):
        self.col = 10
        self.row = 10
        self.items = [
            [0, 1, 1, 1, 1, 1, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 1, 0, 1, 0, 0],
            [0, 0, 0, 1, 0, 1, 0, 0, 0, 0],
            [0, 1, 0, 1, 0, 1, 0, 1, 1, 0],
            [0, 1, 0, 1, 0, 1, 0, 1, 0, 0],
            [0, 1, 1, 1, 0, 1, 0, 1, 0, 1],
            [0, 1, 0, 0, 0, 1, 0, 1, 0, 1],
            [0, 1, 0, 1, 1, 1, 0, 1, 0, 0],
            [1, 0, 0, 0, 0, 0, 0, 1, 0, 0],
            [0, 0, 0, 0, 1, 1, 1, 1, 0, 0]
        ]
        self.x = x
        self.y = y

    def mark(self, pos_to_mark):
        self.items[pos_to_mark.x][pos_to_mark.y] += 1

    def check_visited(self, pos_to_check):
        if pos_to_check.x == -1 or pos_to_check.y == -1:
            return 1  # return True if position has error / is invalid
        else:
            return self.items[pos_to_check.x][pos_to_check.y]
