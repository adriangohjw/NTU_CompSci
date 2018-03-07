print('Fibonacci Sequence')
a = 1av
b = 1
while a < 1000:
    print(a)
    a, b = b, a+b
print('done')
print()

# Better code
print('Padovan Sequence')
a = b = c = 1
while a < 1000:
    print(a)
    a, b, c = b, c, a+b
print('done')
print()

print('Padovan Sequence')
a = 1
b = 1
c = 1
while a < 1000:
    print(a)
    print(b)
    print(c)
    a += b
    b += c
    c += a
print('done')