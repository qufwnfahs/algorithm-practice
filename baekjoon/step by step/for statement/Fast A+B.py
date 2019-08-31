# input
# 5 (test case number)
# 1 1
# 12 34
# 5 500
# 40 60
# 1000 1000

# output
# 2
# 46
# 505
# 100
# 2000

import sys

def getSum(testCases) :
    for x in range(testCases) :
        numbers = list(map(int, sys.stdin.readline().rstrip().split(' ')))
        a = numbers[0]
        b = numbers[1]

        print(a+b)

testCases = int(sys.stdin.readline().rstrip())

getSum(testCases)




