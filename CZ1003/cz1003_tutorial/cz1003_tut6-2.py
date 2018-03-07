import random
import string


def main():

    input('Enter length of random email address to be generated.')

    # list of available characters and numbers in local-part
    available = string.ascii_lowercase + string.ascii_uppercase + string.digits

    local_num = random.randint(1,64)  # number of characters in local-part
    print('Length of local-part: ', local_num)
    
    local_string = ''  
    for x in range(0, local_num, 1):
        local_string += random.choice(available)  # add random char to local-part

    local_string += '@example.com'
    print('Password generated: ', local_string) 

    print()    

while 1:
    main()
