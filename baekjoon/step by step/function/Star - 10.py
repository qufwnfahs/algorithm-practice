''' 도움 출처
https://m.blog.naver.com/PostView.nhn?blogId=moonsoo5522&logNo=220706431458&proxyReferer=https%3A%2F%2Fwww.google.com%2F

멍떄리기 전문가
'''

lines = int(input())

star = [[" "]*lines for i in range(lines)]

def paintStar(y, x, lines) :
    if lines == 1 :
        star[y][x] = "*"
        return

    div = int(lines / 3)

    for i in range(3) :
        for j in range(3) :
            if i == 1 and j == 1 :
                continue
            else :
                paintStar(y+(i*div), x+(j*div), div)

def printStar(star) :
    for x in range(lines) :
        for y in range(lines) :
            print(star[x][y], end='')
        print()

paintStar(0, 0, lines)
printStar(star)


