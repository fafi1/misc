l = ['a', 'b', 'c']

for x in l:
    print(x)

l[len(l):] = ['d']
print(l)

l[50:] = 'e'
print(l)
