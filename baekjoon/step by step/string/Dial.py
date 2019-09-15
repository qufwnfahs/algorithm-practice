dial_string = input()
time = 0

for x in dial_string :
    n = ord(x)

    if n >= 65 and n <= 67 :
        time += 3
    elif n >= 68 and n <= 70 :
        time += 4
    elif n >= 71 and n <= 73 :
        time += 5
    elif n >= 74 and n <= 76 :
        time += 6
    elif n >= 77 and n <= 79 :
        time += 7
    elif n >= 80 and n <= 83 :
        time += 8
    elif n >= 84 and n <= 86 :
        time += 9
    elif n >= 87 and n <= 90 :
        time += 10

print(time)

