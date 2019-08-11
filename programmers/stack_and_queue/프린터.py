# <문제 설명> #
# -----------------------------------------------------------#
# 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼낸다.
# 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면
#    J를 대기목록의 가장 마지막에 넣는다.
# 3. 그렇지 않으면 J를 인쇄한다.

# <제한 사항> #
# -----------------------------------------------------------#
# 현재 대기목록에는 1개 이상 100개 이하의 문서가 있다.
# 인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다.
# location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며
# 대기목록의 가장 앞에 있으면 0, 두번째에 있으면 1로 표현한다.

# <입출력 예> #
# -----------------------------------------------------------#
# input [2, 1, 3, 2] location 2 -> output 1
# input [1, 1, 9, 1, 1, 1] location 0 - > output 5

def solution(priorities, location) :
    popCount = 0
    targetPos = location

    while True :
        curr = priorities[0]

        if curr >= max(priorities) :    
            priorities.pop(0)
            popCount += 1
            if targetPos == 0 :
                return popCount
            else :
                targetPos -= 1
        else :
            priorities.append(priorities.pop(0))

            if targetPos == 0 :
                targetPos = len(priorities)-1
            else :
                targetPos -= 1


priorities = [1, 1, 9, 1, 1, 1]
print(solution(priorities, 0))
    
