import math

radius_str = input("Enter the radius of your circle: ")
radius_int = int(radius_str)

circumference = 2 * math.pi * radius_int
area = math.pi * (radius_int ** 2)

print("The circumference is: {:.2f}, and the area is {:.2f}.".format(circumference, area))
