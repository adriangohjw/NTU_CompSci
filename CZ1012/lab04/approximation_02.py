import math


def d1_fx_approx(a, h):
    def fx(var):
        return math.sin(var)
    return (fx(a+h) - fx(a-h)) / (2 * h)


for h in range(1, 18):
    approx = math.pow(10, (-1 * h))
    result = d1_fx_approx(10, approx)
    print("approximation result for h = -{} is : {}".format(h, result))

