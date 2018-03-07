import math


def older(person):
    print()
    print('Person ', person, ' is older')


def main():

    # compiling the bday for person 1
    print('please input birthday of 1st person')
    p1_year = int(input('\tyear: ')) * math.pow(10, 4)
    
    p1_month = 0
    while p1_month > 12 or p1_month == 0:
        p1_month = int(input('\tmonth: '))
    p1_month *= math.pow(10,2)
            
    p1_day = 0
    while p1_day > 31 or p1_day ==0:
        p1_day = int(input('\tday: '))

    # compiling the bday for person 2
    print('please input birthday of 2nd person')
    p2_year = int(input('\tyear: ')) * math.pow(10,4)
    
    p2_month = 0
    while p2_month > 12 or p2_month == 0:
        p2_month = int(input('\tmonth: '))
    p2_month *= math.pow(10,2)
    
    p2_day = 0
    while p2_day > 31 or p2_day == 0:    
        p2_day = int(input('\tday: '))

    # summing up each's birthday
    p1_bday = p1_year + p1_month + p1_day
    p2_bday = p2_year + p2_month + p2_day

    if (p1_bday == p2_bday):
        print('they have the same birthday')
    elif (p1_bday < p2_bday):
        older(1)
    else:
        older(2)

    print()

while 1:
    main()
