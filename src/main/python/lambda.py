# - Lambda vs functions
# - Lambda examples

# 1 - write filter function with lambda parameter x < 0, x>0, x % 2==0
# 2 - Homework: studends born in summer.


def f3(x):
    return 3 * x


def f4(x):
    return 4 * x


# n default=3; eger verilmemisse, degeri 3 tur.
def f_degisken(x, n=3):
    return n * x


# closure
def f_c(n):
    # lambda fonksiyonu
    return lambda x: x * n


for i in range(10):
    print("i=", i, "f(i)=", f3(i))

print("--------------------------------")
for i in range(10):
    print("i=", i, "f(i)=", f4(i))

print("--------------------------------")
for i in range(10):
    print("i=", i, "f(i)=", f_degisken(i, 6))

print("--------------------------------")

f = f_c(3)

print(f(5))


def fx(x):
    return 3 * x + 1


# anonim fonksiyon denilir
f_x = lambda x: 3 * x + 1


def filter(numbers, fn):
    sonuc = []
    for x in numbers:
        if fn(x):
            sonuc.append(x)
    return sonuc


numbers = [0, 9, 11, 12, -1, -2, 10, 3, 5, 8, 10]
sonuclar = filter(numbers, lambda x: x < 0)
print(sonuclar)

sonuclar = filter(numbers, lambda x: x >= 0)
print(sonuclar)

sonuclar = filter(numbers, lambda x: x % 2 == 0)
print(sonuclar)

sonuclar = filter(numbers, lambda x: x > 10)
print(sonuclar)

isimler = ["Hasari", "Mehmet", "Elif", "Fatma", "Murat", "Haydar"]
sonuclar = filter(isimler, lambda x: len(x) > 4)
print(sonuclar)

sonuclar = filter(isimler, lambda x: x[0] == 'H')
print(sonuclar)

sonuclar = filter(isimler, lambda x: x[len(x) - 1] == 'f' or x[len(x) - 1] == 'F')
print(sonuclar)

sonuclar = filter(isimler, lambda x: x[-1] == 'f' or x[-1] == 'F')
print(sonuclar)


# Odev 1: H is ile baslayip r ile biten isimleri listelesini

# Odev 2: Yeni bir filter fonksiyonu asagidaki ogrenci (student listesi icin yazin)
class Student:
    def __init__(self, isim, dogum_ayi):
        self.name = isim
        self.birthday = dogum_ayi

    def __str__(self):
        return "name:" + self.name + ", birthday:" + self.birthday


def student_filter(students, fn):
    return filter(students, fn)


# girdi parameters: inputs
ogrenciler = [Student("Mehmet", "Agustos"), Student("Ahmet", "Ocak"), Student("Hemo", "Agustos")]
# yaz aylarinda dogan ogrencileri filtrelesin.
sonuclar = student_filter(ogrenciler, lambda x: x.birthday == 'Ocak')
for s in sonuclar:
    print(s)
