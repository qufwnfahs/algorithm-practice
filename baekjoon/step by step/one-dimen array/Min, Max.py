''' input
5
20 10 35 30 7
'''

''' output
7 35
'''

import sys

def printMinAndMax() :
    numbers = list(map(int, sys.stdin.readline().rstrip().split(' ')))
    print(min(numbers))
    print(max(numbers))
    

countOfNumbers = int(sys.stdin.readline().rstrip())
printMinAndMax()
