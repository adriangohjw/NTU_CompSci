from sense_hat import SenseHat
from time import sleep

sense = SenseHat()

while True:
    pitch = sense.get_orientation()['pitch']
    roll = sense.get_orientation()['roll']
    print("pitch {0} roll {1}".format(round(pitch,0), round(roll,0)))
    sleep(0.05)
