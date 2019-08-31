# input
# 472
# 385

# output
# 2360
# 3776
# 1416
# 181720

def process(x, y):
    base = int(x)

    for i in y[::-1]:
        value = base * int(i)
        print(value)


def multiply(x, y):
    x = int(x)
    y = int(y)

    print(x * y)


x = input()
y = input()

process(x, y)
multiply(x, y)
