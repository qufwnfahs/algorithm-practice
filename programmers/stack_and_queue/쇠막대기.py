# 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다.
# 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은
# 겹치지 않도록 놓는다.
# 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.
# 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.

# 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 "()"으로 표현한다.
# 모든 "()"는 반드시 레이저를 표현한다.
# 쇠막대기의 왼쪽 끝은 "("로, 오른쪽 끝은 ")"로 표현한다.

# arrangement의 길이는 최대 100,000
# arrangement의 여는 괄호와 닫는 괄호는 항상 쌍을 이룬다.

# input "()(((()())(())()))(())" output 17

# ()
# 레이저를 확인
# 앞에 안닫힌 막대기 개수 : 0

# () (((()
# 레이저를 확인
# 안닫힌 막대기 수 : 3
# () (((() ()
# 레이저를 확인
# 안닫힌 막대기 수 : 3

# () (((() () ) ( ()
# 레이저를 확인
# 닫힌 막대기 : 1
# 열린 막대기 수 : 3

# () (((() () ) ( () ) ()
# 레이저를 확인
# 닫힌 막대기 수 : 1
# 열린 막대기 수 : 2

# () (((() () ) ( () ) () )) ( ()
# 레이저를 확인
# 닫힌 막대기 수 : 2
# 열린 막대기 수 : 1

# () (((() () ) ( () ) () )) ( () )
# 닫힌 막대기 수 : 1
# 열린 막대기 수 : 0

def solution(arrangement) :
    open = 0
    close = 0
    stick = 0
    
    for i in range(len(arrangement)-1) :
        if arrangement[i] == "(" and arrangement[i+1] != ")" :
            open += 1
        elif arrangement[i] == ")" and arrangement[i-1] != "(" :
            close += 1
            open -= 1
        else :
            if arrangement[i] != "(" :
                stick += open + close
                close = 0
    
    stick += open + close

    return stick

def solutionOthers(arrangement) :
    answer = 0
    sticks = 0
    rasor_to_zero = arrangement.replace("()","0")

    for i in rasor_to_zero :
        if i == "(" :
            sticks += 1
        elif i == "0" :
            answer += sticks
        else :
            sticks -= 1
            answer += 1

    return answer
            
print(solution(arrangement))
