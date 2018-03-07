def main():

    user_input = int(input('input height: '))

    output = ''
    x = 1
    
    while x <= user_input:
        if x%2 == 0:
            output = 'BB' + output
        else:
            output = 'AA' + output
        print(output)
        x += 1
    
    print()

while 1:
    main()
