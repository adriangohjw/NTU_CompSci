import math


def fx(x):
    return x / (1 + math.pow(x, 2))


def interval(a, b, n):
    return (b - a) / n


for n in range(5, 55, 5):
    result = 0
    my_interval = interval(0, 2, n)
    xi = 0
    for x in range(0, n+1):
        if x == 0 or x == n:
            result += fx(xi)
        else:
            result += (2 * fx(xi))
        xi += my_interval
    result *= (my_interval / 2)
    print("trapezoidal result for n = {} is : {}".format(n, result))

