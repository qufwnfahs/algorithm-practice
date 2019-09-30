n = int(input())

cnt = 1
tg = 1

while True :
    if n <= tg :
        break
    tg += cnt * 6
    cnt += 1

print(cnt)
