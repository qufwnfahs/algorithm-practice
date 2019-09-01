''' input
1 2 3 4 5 6 7 8
8 7 6 5 4 3 2 1
8 1 7 2 6 3 5 4
'''

'''output
ascending
descending
mixed
'''

import sys

asc = "ascending"
dsc = "descending"
mix = "mixed"

def checkScale(numbers) :
    if numbers == sorted(numbers) :
        print(asc)
    elif numbers == sorted(numbers, reverse=True) :
        print(dsc)
    else :
        print(mix)


numbers = list(map(int, sys.stdin.readline().rstrip().split(' ')))

checkScale(numbers)
