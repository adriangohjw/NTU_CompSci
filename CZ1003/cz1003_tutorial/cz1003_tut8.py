import random


def shuffleCards():
    my_list = list(range(1, 11))
    random.shuffle(my_list)
    return my_list


def simulateDecision(current_numberNumber):
    if current_numberNumber > 5:
        return False
    elif current_numberNumber < 6:
        return True
    else:
        print('Correct guess!')


def playTurn(current_number, next_number):
    global correct_guess
    if simulateDecision(current_number):
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