import math


def fx(x):
    return x / (1 + math.pow(x, 2))


def interval(a, b, n):
    return (b - a) / n


for n in range(5, 55, 5):
    result = 0
    my_interval = interval(0, 2, n)

    xi = 0
    for count in range(1, n+1):
        xi += my_interval
        xi_avg = xi - (0.5 * my_interval)
        result += (my_interval * fx(xi_avg))
    print("midpoint result for n = {} is : {}".format(n, result))

