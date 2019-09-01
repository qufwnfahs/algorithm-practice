''' input
3
29
38
12
57
74
40
85
61
'''

''' output
85
8
'''

import sys

countOfNumbers = 9

def findMaxWithIndex(numbers) :
    maxValue = max(numbers)
    idx = numbers.index(maxValue)

    print(maxValue)
    print(idx+1)

numbers = []

for x in range(countOfNumbers) :
    number = int(sys.stdin.readline().rstrip())
    numbers.append(number)

findMaxWithIndex(numbers)
