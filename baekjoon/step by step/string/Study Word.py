string = input().upper()

def count(string) :
    arr = [string.count(chr(c)) for c in range(65, 91)]

    maxVal = max(arr)

    if arr.count(maxVal) == 1 :
        print(chr(arr.index(maxVal)+65))
    else :
        print("?")

count(string)
