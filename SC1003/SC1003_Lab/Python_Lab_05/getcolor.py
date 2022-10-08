def get_color(color):
    keep_looping = True
    no_of_try=1
    while keep_looping:
        color_str=input("Enter the value of the " + color + " color for message (0 to 255):")
        
        try:
            if 0 <= int(color_str) <= 255:
                keep_looping = False
                return int(color_str)
            else:
                print("You have entered {} which does not fall between 0 and 255".format(color_str))
        
        except ValueError:
            print("You did not enter an integer")
        
        if no_of_try >= 3:
            keep_looping = False
            return 0
        
        else:
            no_of_try += 1

if __name__ == "__main__":
    get_color("red")
    get_color("green")
    get_color("blue")