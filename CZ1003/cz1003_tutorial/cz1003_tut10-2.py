import re

myfile = open('cz1003_tut10-2.txt', 'r')

count_symbol = 0
count_number = 0
count_upper = 0
count_lower = 0
count_word = 0
count_space = 0

for i in myfile:
    i = i.replace('\r', '')
    i = i.replace('\n', '')
    count_word += len(i.split())
    print(i)
    for character in i:
        if character.isdigit():
            count_number += 1
        if character.islower():
            count_lower += 1
        if character.isupper():
            count_upper += 1
        if re.search('[^A-Za-z0-9]', character):
            count_symbol += 1
        if character.isspace():
            count_space += 1

print()
print('Count (Symbol): ', count_symbol)
print('Count (Number): ', count_number)
print('Count (Upper): ', count_upper)
print('Count (Lower): ', count_lower)
print('Count (Space): ', count_space)
print('Count (Word): ', count_word)