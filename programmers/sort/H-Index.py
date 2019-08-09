# 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고
# 나머지 논문이 h번 이하 인용되었다면 h가 이 과학자의 H-Index

# 논문의 수는 1 <= x <= 1,000
# 논문 별 인용 횟수는 0 <= x <= 10,000

# input [3, 0, 6, 1, 5]
# 논문의 수는 5편
# 그 중 3편의 논문은 3회 이상 인용
# 나머지 2편의 논문은 3회 이하 인용
# H-Index = 3

# input [22, 42] output 2
# H-Index의 최대값을 찾는 문제

def solution(citation) :
    sort = sorted(citation, reverse=True) 
    answer = 0
    max = 0
    
    for x in range(0, len(sort)) :
        # print("%d번 인용된 논문이 %d편 이상" %(sort[x], x+1))
        if sort[x] == x+1 : 
            answer = sort[x]
            return answer
        
        elif sort[x] > x+1 and max < x+1 :
            max = x+1

    return max

def solutionOthers(citation) :
    citation = sorted(citation)
    l = len(citation)

    for i in range(l) :
        if citation[i] >= l-i : # 최대값을 찾는 문제
                                # 값이 같은 걸 먼저 찾는 것이 아니라
            return l-i
    return 0


def solutionOthers2(citation) :
    citation.sort(reverse=True)

    # enumerate 함수
    # 리스트가 있는 경우 순서와 리스트의 값을 전달하는 기능
    # enumerate는 "열거하다" 라는 이다.
    # 이 함수는 순서가 있는 자료형(list, tuple, string)을 입력으로 받아
    # 인덱스 값을 포함하는 enumerate 객체를 리턴한다.

    # enumerate(citation, start=1)
    # citation의 인덱스 값과 인덱스 위치의 값을 열거
    # start=1 -> 인덱스를 0이 아닌 1로 (실제로는 0, 표기는 1)
    
    # up = map(min, enumerate(citation, start=1)
    # (x편 이상, y번 인용된 논문) format에서 x, y중 작은 값들만 고른다.
    # 1편 이상, 6번 인용 -> 1편 이상이 1번 인용됨
    # 2편 이상, 5번 인용 -> 2편 이상이 2번 인용됨
    # 3편 이상, 3번 인용 -> 3편 이상이 3편 인용됨
    # 4편 이상, 1번 인용 -> 1편 이상이 1번 인용됨
    # 5편 이상, 0번 인용 -> 0편 이상이 0번 인용됨

    # max(up)
    # 나올 수 있는 h 값 중 가장 큰 값을 고른다.
    
    answer = max(map(min, enumerate(citation, start=1)))
    return answer

citation = [3, 0, 6, 1, 5]

print(solution(citation))

citation.sort(reverse=True)
for i, name in enumerate(citation, start=1) :
    print(i, name)

print(list(map(min, enumerate(citation, start=1))))
