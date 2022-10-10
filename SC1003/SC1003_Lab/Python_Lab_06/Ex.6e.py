from sense_hat import SenseHat
from time import sleep

sense = SenseHat()

#Define colour
r = (255,0,0)
g = (0,255,0)
b = (0,0,0)
w = (255,255,255)

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

#Initialize marble
x = 2
y = 2
board[y][x] = w

game_over = False

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
    sleep(0.05)
    
sense.show_message("You win!", scroll_speed=0.03)