def grading(score):
    if score >= 85:
        return 'A'
    elif score >= 65:
        return 'B'
    elif score >= 45:
        return 'C'
    else:
        return 'D'


def main():
    # assuming score ranges from 0 to 100
    min_score = 100
    max_score = 0
    
    print('note: enter -1 to end.')

    while 1:
        score = input('input score: ')  # ask user for score input
        if int(score) == -1:  # end while loop if user enter -1
            break
        grade = print('  grade: ', grading(float(score)))  # display grade

        # update max_score and min_score (if applicable)
        if float(score) > max_score:
            max_score = float(score)
        if float(score) < min_score:
            min_score = float(score)

    if min_score == 100 and max_score == 0:  # to handle -1 on first input
        print('no score recorded')
    else:
        print('max_score = ', max_score)
        print('min_score = ', min_score)

    print()
    
while 1:
    main()
