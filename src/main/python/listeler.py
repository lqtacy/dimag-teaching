names = ["Hasari", "Furkan", "Elif", "Haydar"]

print(names)

for i in range(len(names)):
    names[i] = names[i].lower()

print(names)

for i in range(len(names)):
    names[i] = "HH:" + names[i].lower()

print(names)



rakamlar = [2, 6, 8, 11, 90]

for i in range(len(rakamlar)):
    rakamlar[i] = rakamlar[i]*rakamlar[i]


toplam = 0
for i in range(len(rakamlar)):
    toplam = toplam  + rakamlar[i]


print(rakamlar)
print(toplam)


