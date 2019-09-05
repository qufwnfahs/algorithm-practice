''' input
3
'''

''' output
7
1 3
1 2
3 2
1 3
2 1
2 3
1 3
'''

# 1) 맨 밑판을 제외한 원판을 2번에 옮긴다.
# 2) 맨 밑판을 3에 옮긴다.
# 3) 2번에 쌓인 원판을 3에 옮긴다..

import sys

def hanoi(n, start, end, sub) :
    if n == 0 :
        return
    hanoi(n-1, start, sub, end);
    print(start, end);
    hanoi(n-1, sub, end, start);

n = int(sys.stdin.readline().rstrip())

print(pow(2, n) - 1)
hanoi(n, 1, 3, 2);
