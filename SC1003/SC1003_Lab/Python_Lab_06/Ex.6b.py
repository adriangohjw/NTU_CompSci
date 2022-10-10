from sense_hat import SenseHat
from time import sleep

sense = SenseHat()

#Define colour
red = (255,0,0)
green = (0,255,0)
b = (0,0,0)
w = (255,255,255)

sense.clear()

board = [
    [b,b,b,b,b,b,b,b],
    [b,b,b,b,b,b,b,b],
    [b,b,b,b,b,b,b,b],
    [b,b,b,b,b,b,b,b],
    [b,b,b,b,b,b,b,b],
    [b,b,b,b,b,b,b,b],
    [b,b,b,b,b,b,b,b],
    [b,b,b,b,b,b,b,b],
]

x = 2
y = 2
board[y][x] = w

board_1D = sum(board,[])
print(board_1D)
sense.set_pixels(board_1D)