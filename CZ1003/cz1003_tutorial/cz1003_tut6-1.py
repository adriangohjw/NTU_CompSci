import re


def main():
    password = input('Enter password to access strength: ')

    score = 0

    # check if there is any special character
    special_char = re.search('[^A-Za-z0-9]', password)
    if special_char:
        print('Special character(s): Yes')
        score += 1
    else:
        print('Special character(s): No')
        
    # check if there is any number
    number = bool(re.search(r'\d', password))
    if number:
        print('Number(s): Yes')
        score += 1
    else:
        print('Number(s): No')

    # check if there is any letter
    letter = bool(re.search('[a-zA-Z]', password))
    if letter:
        print('Letter(s): Yes')
        score += 1
    else:
        print('Letter(s): No')

    if score == 3:
        print('Password strength: High')
    elif score == 2:
        print('Password strength: Medium')
    elif score == 1:
        print('Password strength: Low')
    else:
        print('No password detected')

    print()
    
while 1:
    main()
