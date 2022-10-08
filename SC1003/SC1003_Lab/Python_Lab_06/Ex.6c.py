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
    return new_x, new_y

#Initialize marble
x = 2
y = 2
board[y][x] = w

while True:
    board[y][x] = b #To fix trailing marble
    pitch = sense.get_orientation()['pitch']
    roll = sense.get_orientation()['roll']
    x,y = move_marble(pitch, roll, x, y)
    board[y][x] = w
    sense.set_pixels(sum(board, []))
    #print("pitch {0} roll {1}".format(round(pitch,0), round(roll,0)))
    sleep(0.05)