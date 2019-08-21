class Student:
    def __init__(self, isim, dogum_ayi):
        self.name = isim
        self.birthday = dogum_ayi


a = Student("Ahmet", "Agustos")
m = Student("Mehmet", "Ocak")

# girdi parameters: inputs
ogrenciler = [Student("Mehmet", "Agustos"), Student("Ahmet", "Ocak"), Student("Hemo", "Agustos")]
cikti = [{"isim":"Mehmet", "ay":"Agustos"}, {"isim":"Ahmet", "ay":"Ocak"}, {"isim":"Hemo", "ay":"Agustos"}]

sayilar = [3, 5, 6, 3, 6, 1, 2]





def degistir(students):
    pass


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
