''' input
5
OOXXOXXOOO
OOXXOOXXOO
OXOXOXOXOXOXOX
OOOOOOOOOO
OOOOXOOOOXOOOOX
'''

'''output
10
9
7
55
30
'''

import sys

def printPoint(testCases) :
    for x in range(testCases) :
        quiz = sys.stdin.readline().rstrip()
        point = 0
        bonus = 0
        
        for y in quiz :
            if y == "O" :
                point += (1 + bonus)
                bonus += 1
            else :
                bonus = 0
        print(point)

testCases = int(sys.stdin.readline().rstrip())

printPoint(testCases)
