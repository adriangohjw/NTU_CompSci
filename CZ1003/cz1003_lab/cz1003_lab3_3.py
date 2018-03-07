conversion = 1.2008


def main():
    
    start = int(input('start S$: '))
    end = int(input('end S$: '))
    step = int(input('step S$: '))

    print('Table 1 with for')
    for x in range(start, end+1, step):
        usd = x/conversion
        print('\tS$ {x} = US$ {usd}'.format(x=x, usd=usd))

    print('Table 2 with while')
    while start <= end:
        usd = start/conversion
        print('\tS$ ', start, ' = US$ ', usd)
        start += step

    print()

while 1:
    main()
