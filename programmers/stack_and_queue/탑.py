# 발사한 신호는 신호를 보낸 탑보다 높은 탑에서만 수신한다.
# 한 번 수신된 신호는 다른 탑으로 송신되지 않는다.

# 맨 왼쪽부터 순서대로 탑의 높이를 담은 배열 heights가 매개변수로 주어질 때
# 각 탑이 쏜 신호를 어느 탑에서 받았는지 기록한 배열을 return하도록

# heights는 길이 2 이상 100 이하인 정수 배열이다.
# 모든 탑의 높이는 1 이상 100 이하이다.
# 신호를 수신하는 탑이 없으면 0으로 표시한다.

# input [6, 9, 5, 7, 4] -> output [0, 0, 2, 2, 4]
# input [3, 9, 9, 3, 5, 7, 2] -> output [0, 0, 0, 3, 3, 3, 6]

def solution(heights) :
    answer = [0]

    for x in range(1, len(heights)) :
        cmp = heights[:x]
        sender = heights[x]
        currPos = len(cmp)

        while cmp :
            if cmp.pop() > sender :
                answer.append(currPos)
                break
            else :
                currPos -= 1
        if currPos == 0 :
            answer.append(0)

    return answer

def solutionOthers(heights) :

    ans = [0] * len(heights) # ans [0, 0, 0, 0, 0]

    for i in range(len(heights)-1, 0, -1) :
        for j in range(i-1, -1, -1) :
            if heights[i] < heights[j] :
                ans[i] = j+1
                break

    return ans

print(solutionOthers([6, 9, 5, 7, 4]))
        
