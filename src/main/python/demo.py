# dictionary
employees = {"haydar": 34, "Mehmet": 30, "Ahmet": 20}
for name in employees:
    print(name)

for name, age in employees.items():
    print(name, "==>", age)


#scope: bir degiskenin actif oldugu alan

def add(sayilar):
    total = 0
    for i in range(0, len(sayilar)):
        total = total + sayilar[i]

    sayilar.clear()
    sayilar = []
    return total


print("---------------------------------------------")
numbers = [7,8,1,2]

print (numbers)
result = add(numbers)
print (numbers)

print(result)
