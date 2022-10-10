from sense_hat import SenseHat
import random
import time

sense = SenseHat()

sense.clear()

#Define colour
red = (255,0,0)
green = (0,255,0)
blue = (0,0,255)
yellow = (255,255,0)
black = (0,0,0)
white = (255,255,255)

def colourRandom():
    return (random.randint(100,255), random.randint(100,255), random.randint(100,255))

#Given image in problem
""" 
image_pixels =	[black, black, black, black, black, black, black, black,
                black, black, black, yellow, black, black, black, black,
                black, black, yellow, yellow, yellow, black, black, black,
                black, yellow, black, yellow, black, yellow, black, black,
                black, black, black, yellow, black, black, black, black,
                black, black, black, black, yellow, black, black, black,
                black, black, black, yellow, black, black, black, black,
                black, black, black, black, black, black, black, green]
"""
orientation = [0, 90, 180, 270]

while True:
    """
    for i in range (len(image_pixels)):
        if image_pixels[i] == red:
            image_pixels[i] = yellow
        elif image_pixels[i] == yellow:
            image_pixels[i] = red
    """
    image_pixels =	[black, colourRandom(), colourRandom(), black, black, colourRandom(), colourRandom(), black,
                    colourRandom(), colourRandom(), colourRandom(), colourRandom(), colourRandom(), colourRandom(), colourRandom(), colourRandom(),
                    colourRandom(), colourRandom(), colourRandom(), colourRandom(), colourRandom(), colourRandom(), colourRandom(), colourRandom(),
                    colourRandom(), colourRandom(), colourRandom(), colourRandom(), colourRandom(), colourRandom(), colourRandom(), colourRandom(),
                    colourRandom(), colourRandom(), colourRandom(), colourRandom(), colourRandom(), colourRandom(), colourRandom(), colourRandom(),
                    black, colourRandom(), colourRandom(), colourRandom(), colourRandom(), colourRandom(), colourRandom(), black,
                    black, black, colourRandom(), colourRandom(), colourRandom(), colourRandom(), black, black,
                    black, black, black, colourRandom(), colourRandom(), black, black, black]
    
    sense.set_rotation(orientation[random.randint(0,3)])
    sense.set_pixels(image_pixels)
    time.sleep(1)
