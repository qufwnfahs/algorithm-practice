# input
# 1 2

# output
# <

def compare(x, y) :
    if x > y :
        print(">")
    elif x == y :
        print("==")
    else :
        print("<")

inputs = list(map(int, input().split(' ')))

x = inputs[0]
y = inputs[1]
compare(x, y)

