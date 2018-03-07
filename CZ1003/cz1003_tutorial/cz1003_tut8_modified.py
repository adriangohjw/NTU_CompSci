import random


def shuffleCards():
    my_list = list(range(1, 11))
    random.shuffle(my_list)
    return my_list


def simulateDecision(list_remaining):
    count_higher = count_lower = 0

    for i in range(1, len(list_remaining)):
        if list_remaining[i] > list_remaining[0]:
            count_higher += 1
        else:
            count_lower += 1
    print('Count (higher): {}, Count (lower): {}'.format(count_higher, count_lower))

    if count_higher > count_lower:
        print('Guess is higher')
        return False
    else:
        print('Guess is lower')
        return True


def playTurn(current_number, next_number):
    global correct_guess
    if simulateDecision(generated_list):
        if next_number < current_number:
            print('Correct! {} is smaller than {}'.format(next_number, current_number))
            correct_guess = True
        else:
            print('Wrong! {} is larger than {}'.format(next_number, current_number))
    else:
        if next_number > current_number:
            print('Correct! {} is larger than {}'.format(next_number, current_number))
            correct_guess = True
        else:
            print('Wrong! {} is smaller than {}'.format(next_number, current_number))
        print()

correct_guess = False
generated_list = shuffleCards()
while not correct_guess and len(generated_list) != 1:
    print(generated_list)
    current_number = generated_list[0]
    next_number = generated_list[1]
    playTurn(current_number, next_number)
    generated_list.remove(current_number)