def main():
    user_input = int(input('input pattern width: '))

    for x in range(1, user_input+1, 1):
        print(x * '*')

    for y in range(user_input-1, 0, -1):
        print(y * '*')
        
    print()
    
while 1:
    main()
