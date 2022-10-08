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

#All 4 corners
sense.set_pixel(0, 0, red) #TOP LEFT
sense.set_pixel(7, 0, green) #TOP RIGHT
sense.set_pixel(0, 7, blue) #BOTTOM LEFT
sense.set_pixel(7, 7, yellow) #BOTOOM RIGHT

time.sleep(1)
sense.clear()

#4 Colours at random position
while True:
    #All 4 corners random
    sense.set_pixel(random.randint(0,7), random.randint(0,7), red) #TOP LEFT
    sense.set_pixel(random.randint(0,7), random.randint(0,7), green) #TOP RIGHT
    sense.set_pixel(random.randint(0,7), random.randint(0,7), blue) #BOTTOM LEFT
    sense.set_pixel(random.randint(0,7), random.randint(0,7), yellow) #BOTOOM RIGHT

    time.sleep(1)
    sense.clear()