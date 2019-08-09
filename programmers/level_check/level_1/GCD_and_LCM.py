# 두 수를 입력받아 최대공약수와 최소공배수 반환
# 앞엔 최대공약수, 뒤엔 최소공배수

def solution(n, m) :
    gcdVal = gcd(n, m)
    lcmVal = lcm(n, m)

    answer = [gcdVal, lcmVal]
    
    return answer


# 나머지 연산을 하면 큰 값과 작은 값이 swap 되게됨
# min, max 배제 가능

def gcd(n, m) :
    if m == 0 :
        return n
    else :
        return gcd(m, n%m)

# 최소공배수는 두 수의 곱 / 최대공약수

def lcm(n, m) :
    return (int) (n * m / gcd(n, m))

print(solution(3, 12))
