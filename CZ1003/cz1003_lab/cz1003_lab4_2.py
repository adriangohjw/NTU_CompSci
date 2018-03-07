def main():

    user_input = input('input numbers to sum without commas\n')
    
    sum = 0
    for x in user_input:
        sum += int(x)

    print('Result is : <{:10d}>'.format(sum))
    print()

while 1:
    main()
