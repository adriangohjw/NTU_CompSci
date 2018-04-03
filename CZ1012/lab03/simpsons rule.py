import math


def fx(x):
    return x / (1 + math.pow(x, 2))


def interval(a, b, n):
    return (b - a) / n


for n in range(10, 55, 10):
    result = 0
    my_interval = interval(0, 2, n)
    xi = 0
    for x in range(0, n+1):
        if x == 0 or x == n:
            result += fx(xi)
        elif x % 2 == 1:
            result += (4 * fx(xi))
        elif x % 2 == 0:
            result += (2 * fx(xi))
        xi += my_interval
    result *= (my_interval / 3)
    print("simpsons result for n = {} is : {}".format(n, result))

