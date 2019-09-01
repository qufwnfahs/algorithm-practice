''' input
1 1
2 3
3 4
9 8
5 2
0 0
'''

''' output
2
5
7
17
7
'''

import sys

while True :
    numbers = list(map(int, sys.stdin.readline().rstrip().split(' ')))
    a = numbers[0]
    b = numbers[1]

    if a == 0 and b == 0 :
      break

    print(a+b)
