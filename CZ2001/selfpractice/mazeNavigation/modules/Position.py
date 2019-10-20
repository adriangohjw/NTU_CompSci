class Position:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def x_move(self, value):
        self.x += value

    def y_move(self, value):
        self.y += value

    def check_up(self):
        return Position(self.x-1, self.y)

    def check_down(self):
        return Position(self.x+1, self.y)

    def check_left(self):
        return Position(self.x, self.y-1)

    def check_right(self):
        return Position(self.x, self.y+1)