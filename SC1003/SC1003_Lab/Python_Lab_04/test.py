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
    
sense.set_rotation(270)
arrow(green)

while True:
	acceleration = sense.get_accelerometer_raw()
	x = acceleration['x']
	y = acceleration['y']
	z = acceleration['z']

	x=round(x, 0)
	y=round(y, 0)
	z=round(z, 0)

	print("x={0}, y={1}, z={2}".format(x, y, z))