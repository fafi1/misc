import sys

file = sys.argv[1]


def simple_print_all_lines(file):
    f = open(file)
    i = 0
    while True:
        line = f.readline()
        print(str(i) + " " + line, end='')
        i = i + 1
        if not line:
            break
    f.close()
    print()


def print_all_lines_readlines_autoclose(file):
    with(open(file)) as f:
        i = 0
        while True:
            line = f.readline()
            print(str(i) + " " + line, end='')
            i = i + 1
            if not line:
                break
    print()


def read_lines(file):
    with(open(file)) as f:
        return f.readlines()


def read_lines_using_for(file):
    lines = []
    with(open(file)) as f:
        for line in f:
            lines.append(line)
    return lines


print('simple file print')
simple_print_all_lines(file)
print('file print using with')
print_all_lines_readlines_autoclose(file)
print('using read_lines')
print(read_lines(file))
print('using for in')
print(read_lines_using_for(file))
