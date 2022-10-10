from sense_hat import SenseHat
import random
import time

sense = SenseHat()

sense.clear()

#Define colour
red = (255,0,0)
green = (0,255,0)
black = (0,0,0)
white = (255,255,255)
orientation = [0, 90, 180, 270]
points = 0

def arrow(colour):
    image_pixels =	[black, black, black, black, colour, black, black, black,
                    black, black, black, black, black, colour, black, black,
                    black, black, black, black, black, black, colour, black,
                    colour, colour, colour, colour, colour, colour, colour, colour,
                    colour, colour, colour, colour, colour, colour, colour, colour,
                    black, black, black, black, black, black, colour, black,
                    black, black, black, black, black, colour, black, black,
                    black, black, black, black, colour, black, black, black]
    sense.set_pixels(image_pixels)

def correct():
    for i in range(3):
        arrow(green)
        time.sleep(0.2)
        arrow(white)
        time.sleep(0.1)
    arrow(green)
    time.sleep(1)
    sense.clear()

def wrong():
    for i in range(3):
        arrow(red)
        time.sleep(0.5)
        arrow(white)
        time.sleep(0.5)
    arrow(red)
    time.sleep(1)
    sense.clear()

#start
while True:
    randOrientation = orientation[random.randint(0,3)]
    sense.set_rotation(randOrientation)
    arrow(white)
    time.sleep(2-(points*0.05))
    
    #Get orientation of Pi
    acceleration = sense.get_accelerometer_raw()
    x = acceleration['x']
    y = acceleration['y']

    x = round(x, 0)
    y = round(y, 0)
    
    if x == -1 and y == 0 and randOrientation == 0:
        correct()
        points += 1
    elif x == 1 and y == 0 and randOrientation == 180:
        correct()
        points += 1
    elif x == 0 and y == -1 and randOrientation == 90:
        correct()
        points += 1
    elif x == 0 and y == 1 and randOrientation == 270:
        correct()
        points += 1
    else:
        wrong()
        break;

#prints final score

sense.clear()
sense.set_rotation(0)

sense.show_message("Loser", scroll_speed=0.03, text_colour = white)
sense.show_message(str(points), text_colour = white)