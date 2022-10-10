from sense_hat import SenseHat
from getcolor import get_color

sense = SenseHat()
sense.set_rotation(180)
#---------------------------------------------------------
r_int = get_color("red")
g_int = get_color("green")
b_int = get_color("blue")
msg_color = (r_int, g_int, b_int)
sense.show_message("I got it!", text_colour=msg_color)
