# input
# 5
# 1 1
# 2 3
# 3 4
# 9 8
# 5 2

# output
# Case #1: 2
# Case #2: 5
# Case #3: 7
# Case #4: 17
# Case #5: 7

import sys

def getPrettySums(testCases) :
    for x in range(testCases) :
        numbers = list(map(int, sys.stdin.readline().rstrip().split(' ')))
        sum = numbers[0] + numbers[1]

        print("Case #%d: %d" %((x+1), sum))

testCases = int(sys.stdin.readline().rstrip())

getPrettySums(testCases)
