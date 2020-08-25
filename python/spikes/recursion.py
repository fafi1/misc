from math import floor


def log2(n, l):
    if n == 1:
        return l
    return log2(floor(n / 2), l + 1)


print(log2(1, 0))
print(log2(2, 0))
print(log2(4, 0))
print(log2(8, 0))
print(log2(16, 0))
print(log2(32, 0))
print(log2(64, 0))
print(log2(128, 0))
print(log2(256, 0))
