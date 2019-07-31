# 출처 https://burningrizen.tistory.com/125

# list(map(str, numbers)) #
# map(f, iterable)은 함수 f와 반복 가능한(iterable) 자료형을 파라미터로 받는다.
# map은 입력받은 자료형의 각 요소를 함수 f가 수행한 결과를 묶어서 돌려주는 함수이다.
# numbers의 각 요소를 str 타입으로 변환
# map의 결과를 list로 받음

# sorted(list(map(str, numbers)), key=lambda x: x * 3, reverse=True) #
# 원소는 0이상 1000이하 이기 떄문에 가장 긴 원소의 길이는 4이다.
# 이 문제에서 str(x) * 3이면 모든 경우에서 길이는 4 이상이기 때문에
# key=lambda x: x * 3으로 역순으로 정렬한다.
# 3, 30을 비교할때 3333, 30303030을 비교하고 문자열이기 때문에 3333이 더 큰걸로 판별된다.

# numbers = [6, 10, 2]        -> output "6210"
# numbers = [3, 30, 34, 5, 9] -> output "9534330"

import functools

def solution(numbers) :
    return str(int(''.join(sorted(list(map(str, numbers)), key=lambda x: x * 3, reverse=True))))


def solutionComparator(numbers) :
    n = [str(x) for x in numbers] # numbers 각 요소를 str 타입으로 바꾸어 n에 append
    n = sorted(n, key=functools.cmp_to_key(comparator), reverse=True)
    answer = str(int(''.join(n)))
    return answer

def comparator(a, b) :
    t1 = int(a+b)
    t2 = int(b+a)

    return t1 - t2 # 양수, 0, 음수

numbers = [6, 10, 2]
print(solution(numbers))
