n = input()

for i in map(chr, range(ord('a'), ord('z')+1)) :
    print(n.find(i), end=" ")
