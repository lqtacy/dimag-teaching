class Student:
    def __init__(self, isim, dogum_ayi):
        self.name = isim
        self.birthday = dogum_ayi


a = Student("Ahmet", "Agustos")
m = Student("Mehmet", "Ocak")

# girdi parameters: inputs
ogrenciler = [Student("Mehmet", "Agustos"), Student("Ahmet", "Ocak"), Student("Hemo", "Agustos")]
cikti = [{"isim": "Mehmet", "ay": "Agustos"}, {"isim": "Ahmet", "ay": "Ocak"}, {"isim": "Hemo", "ay": "Agustos"}]

sayilar = [3, 5, 6, 3, 6, 1, 2]


def degistir(students):
    sonuc = []
    for o in students:
        ogrenci = {"isim": o.name, "ay": o.birthday}
        sonuc.append(ogrenci)
    return sonuc

def tersi(students):
    sonuc = []
    for o in students:
        ogrenci = Student(o['isim'], o['ay'])
        sonuc.append(ogrenci)
    return sonuc


#sozluk dictionary nasil calisiyor: ekle, sil, ulasma
#liste: list:  ekle, sil, ulasma
#Class: nasil olusturulor, nasil ulasilar (sifat: field, property)

print("----------------------------")
ogrencilerx = degistir(ogrenciler)
print(ogrencilerx)
print("----------------------------")
ogrencilery = tersi(ogrencilerx)
print(ogrencilery)

for o in ogrencilery:
    print(o.name, o.birthday)

def hesapla(sayilar):
    sonuc = {}
    for sayi in sayilar:
        if sayi in sonuc:
            sonuc[sayi] = sonuc[sayi] + 1
        else:
            sonuc[sayi] = 1
    return sonuc


hesaplamalar = hesapla(sayilar)
print(hesaplamalar)


def birthdays(ogrenciler):
    sonuc = {}
    for ogrenci in ogrenciler:
        if ogrenci.birthday in sonuc:
            sonuc[ogrenci.birthday] = sonuc[ogrenci.birthday] + 1
        else:
            sonuc[ogrenci.birthday] = 1

    return sonuc


sonuclar = birthdays(ogrenciler)
print(sonuclar)

# output: ciktilar
{"agustos": 2, "ocak": 1}

print(a.birthday)

print(m.name)
