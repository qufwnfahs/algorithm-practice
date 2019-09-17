words = 0

for i in range(int(input())) :
   s = input()

   if list(s) == sorted(s, key=s.find) :
      words += 1

print(words)
