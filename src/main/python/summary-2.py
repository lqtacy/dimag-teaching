class Student:
    def __init__(self, isim, dogum_ayi):
        self.name = isim
        self.birthday = dogum_ayi





a = Student("Ahmet", "Agustos")
m = Student("Mehmet", "Ocak")

#girdi parameters: inputs
ogrenciler = [Student("Mehmet", "Agustos"), Student("Ahmet", "Ocak"), Student("Hemo", "Agustos")]

#output: ciktilar
{"agustos":2, "ocak":1}

print(a.birthday)

print(m.name)
