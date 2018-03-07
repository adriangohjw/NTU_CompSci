def fib(n):  # discrete math method
    return int((1/(5**0.5))*((((1+5**0.5)/2)**n)-(((1-5**0.5)/2)**n)))

for i in range(1, 10):  # checks by printing first few numbers in the sequence
    print(fib(i))

print()


def fib_2(n):
    if n in (1, 2):
        return 1
    else:
        fn_1 = fn_2 = 1
        loop_counter = 2
        while loop_counter != n:
            fn = fn_1 + fn_2
            fn_2 = fn_1
            fn_1 = fn
            loop_counter += 1
        return fn

for i in range(1, 10):  # checks by printing first few numbers in the sequence
    print(fib_2(i))