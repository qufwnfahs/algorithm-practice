''' input
39
40
41
42
43
44
82
83
84
85
'''

''' output
6
'''

import sys

base = 42
countOfNumbers = 10

def printRest(numbers) :
    rests = set()
    
    for x in numbers :
        rests.add(x % base)

    print(len(rests))

numbers = []

for x in range(countOfNumbers) :
    number = int(sys.stdin.readline().rstrip())
    numbers.append(number)

printRest(numbers)
