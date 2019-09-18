
prices = list(map(int, input().split(" ")))

A = prices[0]
B = prices[1]
C = prices[2]

if B >= C :
    print(-1)
else :
    base = C - B

    result = A // base + 1

    print(result)
