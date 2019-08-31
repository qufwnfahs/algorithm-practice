# input
# 10 10

# output
# 9 25

def getTimeOfAlarm(hour, minute) :
    minute -= 45

    if minute < 0 :
        minute += 60
        hour -= 1
        if hour < 0 :
            hour = 23
        
    print(hour, minute)
times = list(map(int, input().split(' ')))

hour = times[0]
minute = times[1]

getTimeOfAlarm(hour, minute)
