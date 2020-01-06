a, b = 0, 1
n = 1
while n < 900:
    n = a + b
    a = b
    b = n
    print(n)


def fib(a, b, c):
    print(a)
    if b < c:
        fib(b, a + b, c)


fib(0, 1, 90)
fib(a=0, b=1, c=90)
