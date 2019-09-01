''' input
10
'''

''' output
3628800
'''

def factorial(n) :
    if n == 0 :
        return 1
    
    return n * factorial(n-1)

base = int(input())

print(factorial(base))

