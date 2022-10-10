from sense_hat import SenseHat

def menu():
    print(
"""
Select your option:
1) Set message
2) Set text rotation
3) Set text colour
4) Set background colour
5) Set scroll speed
6) Display message on SenseHat
7) Clear SenseHat screen

-1) Quit

"""
        
        )
        
sense = SenseHat()

#default values for initialization
message = "Hello world"
option = rotation = 0
speed = 0.5

color_msg = [255,0,0]
color_bg = [0,255,0]

while True:
    try:
        menu()
        option = int(input("Enter your option: "))
    except:
        print("Only enter an integer")
        
    if(option == 1):
        message = input("Enter message to print out: ")
        print("Message set as: {}".format(message))
        
    elif(option == 2):
        rotation = int(input("Enter rotation (0, 90, 180, 270): "))
        print("Rotation set as: {}".format(rotation))
        
    elif(option == 3):
        color_msg = input("Enter colour of message (x x x): ")
        color_msg = color_msg.split()
        for i in range(len(color_msg)):
            color_msg[i] = int(color_msg[i])
        print("Colour of message set as: {}".format(color_msg))
        
    elif(option == 4):
        color_bg = input("Enter colour of background (x x x): ")
        color_bg = color_bg.split()
        for i in range(len(color_bg)):
            color_bg[i] = int(color_bg[i])
        print("Colour of background set as: {}".format(color_bg))
        
    elif(option == 5):
        speed = float(input("Enter scroll speed: "))
        print("Scroll speed set as: {}".format(speed))

    elif(option == 6):
        sense.low_light = True
        sense.set_rotation(rotation)
        sense.show_message(message, 
        text_colour = color_msg, 
        back_colour = color_bg,
        scroll_speed = speed)
        
        sense.clear()
        sense.low_light = False
        
    elif(option == 7):
        print("SenseHat cleared!")
        sense.clear()
        
    elif(option == -1):
        print("Goodbye")
        break;
        
    else:
        print("Unknown input")


"""
sense.set_rotation(180)

sense.show_message("test",
text_colour = (255,255,0), 
back_colour = (255,0,0), 
scroll_speed = 0.5)

sense.clear()
#sense.clear(100,100,100)
"""
