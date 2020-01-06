def sum1(i, off):
    return int((i * (i + 1)) / 2) + off


def isPrimeRecursive(n, i=3):
    if n <= 1:
        return False
    if n == 2:
        return True
    if i > n / 2:
        return True
    if n % i == 0:
        return False
    else:
        return isPrimeRecursive(n, i + 2)


def isPrime(n, i=3):
    if n <= 1:
        return False
    if n == 2:
        return True

    while i <= n / 2:
        if n % i == 0:
            return False

        i += 2

    return True


def sum1Series(max, off):
    for i in range(max):
        number = sum1(i, off)
        print(f'{number}\t{isPrime(number)}')
    print('---')


max = 8000
sum1Series(max, 31)
