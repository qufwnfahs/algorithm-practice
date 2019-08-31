'''
input

5
1 1
2 3
3 4
9 8
5 2
'''

'''
output

Case #1: 1 + 1 = 2
Case #2: 2 + 3 = 5
Case #3: 3 + 4 = 7
Case #4: 9 + 8 = 17
Case #5: 5 + 2 = 7
'''

import sys

def getMorePrettySum(testCases) :

    for x in range(testCases) :
        numbers = list(map(int, sys.stdin.readline().rstrip().split(' ')))
        a = numbers[0]
        b = numbers[1]
        sum = a+b

        print("Case #%d: %d + %d = %d" %( (x+1), a, b, sum))

testCases = int(sys.stdin.readline().rstrip())

getMorePrettySum(testCases)
