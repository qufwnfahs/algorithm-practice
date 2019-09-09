import math
import sys

n, x, y = map(int, input().split())

def solution(n, x, y, cnt) :
    if n == 1 :
        print(cnt + 2 * x + y)
        return

    size = int(math.pow(2, n-1))

    xDim = x // size
    yDim = y // size
    dim = xDim * 2 + yDim

    div = int(math.pow(4, n-1))
    
    cnt += div * dim

    solution(n-1, x % size, y % size, cnt)
    
solution(n, x, y, 0)
