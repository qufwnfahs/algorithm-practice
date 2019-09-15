croatias = [ "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" ]

s = input()

for x in croatias :
    s = s.replace(x, ' ')

print(len(s))
