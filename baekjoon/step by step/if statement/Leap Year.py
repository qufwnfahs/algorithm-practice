# input
# 2000

# output
# 1

def checkOfLeapYear(year) :
    if (year % 4 == 0 and year % 100 != 0) or year % 400 == 0 :
        print(1)
    else :
        print(0)

year = int(input())

checkOfLeapYear(year)
