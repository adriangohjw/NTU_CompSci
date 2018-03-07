list_first = [50, 60, 70, 80]
list_second = []


def list_processing(list_name, word):
    value_total = 0
    value_max = 0
    for i in range(0, len(list_name)):
        value_total += list_name[i]
        if list_name[i] > value_max:
            value_max = list_name[i]
    try:
        value_avg = value_total/len(list_name)
    except ZeroDivisionError:
        value_avg = 0
        print('The {} list is empty!'.format(word))
    return value_avg, value_max

avg_first, max_first = list_processing(list_first, 'first')
avg_second, max_second = list_processing(list_second, 'second')


def comparison(value1, value2, word):
    if value1 > value2:
        print('First class has a higher {} score of {}!'.format(word, value1))
    elif value2 > value1:
        print('Second class has a higher {} score of {}!'.format(word, value2))
    else:
        print('Both classes have the same {} score!'.format(word))

comparison(avg_first, avg_second, 'average')
comparison(max_first, max_second, 'maximum')