n = int(input())

def printRepeat(repeat, string) :
    for x in string :
        print(repeat * x, end="")
    print()

for x in range(n) :
    repeat, string = input().split()
    repeat = int(repeat)

    printRepeat(repeat, string)
