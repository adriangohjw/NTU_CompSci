from sense_hat import SenseHat
from time import sleep, time
import random

sense = SenseHat()

#Define variables
r = (255,0,0)
g = (0,255,0)
b = (0,0,0)
w = (255,255,255)
game_time = time()
game_over = False

sense.clear()
"""
board = [
    [r,r,r,r,r,r,r,r],
    [r,b,b,b,b,b,b,r],
    [r,b,b,b,b,b,b,r],
    [r,b,b,b,b,b,b,r],
    [r,b,b,b,b,b,b,r],
    [r,b,b,b,b,b,b,r],
    [r,b,b,b,b,b,b,r],
    [r,r,r,r,r,r,r,r],
]
"""
board = [
    [r,r,r,b,b,b,b,r], 
    [r,b,b,b,b,b,b,r],
    [b,b,b,b,g,r,b,r],
    [b,r,r,b,r,r,b,r],
    [b,b,b,b,b,b,b,b],
    [b,r,b,r,r,b,b,b],
    [b,b,b,r,b,b,b,r], 
    [r,r,b,b,b,r,r,r],
]



def move_marble(pitch, roll, x, y):
    new_x = x
    new_y = y
    if 1 < pitch < 179 and x != 0:
        new_x -= 1
    elif 359 > pitch > 179 and x != 7:
        new_x += 1
    
    if 1 < roll < 179 and y != 7:
        new_y += 1
    elif 359 > roll > 179 and y != 0:
        new_y -= 1
    new_x, new_y = check_wall(x, y, new_x, new_y)
    return new_x, new_y

def check_wall(x, y, new_x, new_y):
    if board[new_y][new_x] != r:
        return new_x, new_y
    elif board[new_y][x] != r:
        return x, new_y
    elif board[y][new_x] != r:
        return new_x, y
    else:
        return x, y

def move_target():
    global game_time
    current_time = time()
    if current_time - game_time > 2 and not game_over:
        game_time = time()
        for i in range(len(board)):
            try:
                j = board[i].index(g)
                break
            except:
                pass
        board[i][j] = b
        while True:
            x = random.randint(0,7)
            y = random.randint(0,7)
            if x != j and y != i and board[y][x] != r and board[y][x] != w:
                board[y][x] = g
                break

#Initialize marble
x = 2
y = 2
board[y][x] = w

while not game_over:
    board[y][x] = b
    pitch = sense.get_orientation()['pitch']
    roll = sense.get_orientation()['roll']
    x,y = move_marble(pitch, roll, x, y)
    if board[y][x] == g:
        board[y][x] = w
        sense.set_pixels(sum(board, []))
        sleep(1)
        for i in range(3):
            sense.clear(g)
            sleep(0.2)
            sense.clear()
            sleep(0.2)
        game_over = True
    else:
        board[y][x] = w
        sense.set_pixels(sum(board, []))
    move_target()
    sleep(0.05)
    
sense.show_message("You won!", scroll_speed=0.03)