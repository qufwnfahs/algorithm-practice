# 쿼드 트리

import sys

n = int(sys.stdin.readline().rstrip())

arr = [sys.stdin.readline().rstrip() for _ in range(n)]

def quadTree(size, x, y) :
    if size == 1 :
        return arr[y][x]

    base = size // 2

    t = [ quadTree(base, x, y), quadTree(base, x+base, y),
          quadTree(base, x, y+base), quadTree(base, x+base, y+base) ]

    if len(set(t)) == 1 and t[0] in ('0','1') :
        return t[0]
    else :
        return '(%s%s%s%s)'%tuple(t)

    
print(quadTree(n, 0, 0))
