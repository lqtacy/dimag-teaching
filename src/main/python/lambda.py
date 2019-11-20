# - Lambda vs functions
# - Lambda examples

# 1 - write filter function with lambda parameter x < 0, x>0, x % 2==0
# 2 - Homework: studends born in summer.
from student import Student

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


def filter(fn, elements):
    sonuc = []
    for x in elements:
        if fn(x): #eger dogru ise (test et)
            sonuc.append(x)  #ekle
    return sonuc


numbers = [0, 9, 11, 12, -1, -2, 10, 3, 5, 8, 10]
sonuclar = filter(lambda x: x < 0, numbers)
print(sonuclar)

sonuclar = filter(lambda x: x >= 0, numbers)
print(sonuclar)

sonuclar = filter(lambda x: x % 2 == 0, numbers)
print(sonuclar)

sonuclar = filter(lambda x: x > 10, numbers)
print(sonuclar)

isimler = ["Hasari", "Mehmet", "Elif", "Fatma", "Murat", "Haydar"]
sonuclar = filter(lambda x: len(x) > 4, isimler)
print(sonuclar)

sonuclar = filter(lambda x: x[0] == 'H', isimler)
print(sonuclar)

sonuclar = filter(lambda x: x[len(x) - 1] == 'f' or x[len(x) - 1] == 'F', isimler)
print(sonuclar)

sonuclar = filter(lambda x: x[-1] == 'f' or x[-1] == 'F', isimler)
print(sonuclar)


# Odev 1: H is ile baslayip r ile biten isimleri listelesini

# Odev 2: Yeni bir filter fonksiyonu asagidaki ogrenci (student listesi icin yazin)


# girdi parameters: inputs
ogrenciler = [Student("Mehmet", "Haziran"), Student("Ahmet", "Ocak"), Student("Hemo", "Agustos")]
# yaz aylarinda dogan ogrencileri filtrelesin.
sonuclar = filter(lambda x: x.birthday == 'Haziran' or x.birthday == 'Temmuz' or x.birthday == 'Agustos', ogrenciler)
for s in sonuclar:
    print(s)


sonuclar = filter (lambda x: x < 0, [4, -5, 6, 8, 9,-1])
print(sonuclar)


kelime = "kayak"

#tersini verecek
def reverse(word):
    sonuc = ''
    for i in range(len(word)-1, -1, -1):
        sonuc = sonuc + word[i]
    return sonuc



#palindrome
# def is_palindrome(word):
#     if word == reverse(word):
#         return True
#     else:
#         return False



#palindrome
def is_palindrome(word):
    return word == reverse(word)


result = is_palindrome("haziran")
print(result)
result = is_palindrome("kayak")
print(result)

def f(x, y):
    return x+y

fxy = lambda x, y: x+y

print(fxy(7,8))

numbers = [6, 7, 9,2, 1, 11]

def square(numbers):
    sonuclar = []
    for x in numbers:
        sonuclar.append(x*x)
    return sonuclar


sonuc = [x*x for x in numbers] #list Comprehensions

print(sonuc)


sonuc = [x.birthday for x in ogrenciler] #list Comprehensions
print(sonuc)

kelimeler = ["haziran", "kayak", "mom", "racecar", "temmuz"]
sonuc = [is_palindrome(x) for x in kelimeler] #list Comprehensions
print(sonuc)