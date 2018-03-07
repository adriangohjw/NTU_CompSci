import sys


def main():

    x = float(input('input x: '))
    y = float(input('input y: '))

    if x == 0 and y == 0:
        print('at origin')
    elif x == 0:
        print('at y-axis')
    elif y == 0:
        print('at x-axis')
    elif x > 0:
        if y > 0:
            print('in quadrant 1')
        else:
            print('in quadrant 4')
    elif x < 0:
        if y > 0:
            print('in quadrant 2')
        else:
            print('in quadrant 3')

    user_input = input('Continue? 1 to continue, else exit.\t')
    if user_input == '1':
        print()
    else:
        print('Exiting, bye!')
        sys.exit()

while 1:
    main()
