# Data types: data tipleri

isim = "Eyub"  # String
soyad = 'Karahanli'
soyad = "DigerSoyad"
print(isim, "     -->", soyad, ":", 52)

ad = "Ahmet"
soyad = "Karabey"

isim = ad + "AAA" + soyad
print(isim)

print(isim.lower())
print(isim.split('AAA'))


age = 12  # int (integer) sayi
yas = '12'

if age == yas:
    print("Esittir")
else:
    print("Esit degildir.")

yas = int(yas)
if age == yas:
    print("XXEsittir")
else:
    print("XXEsit degildir.")

muz_fiyati = 12.60  # float ondalik sayilar.

if age == muz_fiyati:
    print("YYEsittir")
else:
    print("YYEsit degildir.")

a = int(10 / 10)
print(a)


#list: liste

isimler = ["Hasari", "Mehmet", "Ayse", "Ferhat"]

ad = isimler[2]
print(ad)

son_isim = isimler[len(isimler)-1]
print(son_isim)
#degerlerii degistirmek icin
isimler[2] = "Fatma"
print(isimler[2])
#degerleri silmek icin

del(isimler[2])
print("Isimxx:",isimler[2])

isimler.append("Ayse")

print("ISIMLER = ", isimler)

print(isimler)
#her elemanina ulasmak icin (iterate)
for isim in isimler:
    print("Isim=", isim)


for i in range(len(isimler)):
    isimler[i] = isimler[i]+"X"

print(isimler)


sayilar = [7, 8, 9, 11, 6, 5]
for i in range(len(sayilar)):
    sayilar[i] = sayilar[i]*sayilar[i]

print(sayilar)


#algorithma fonksiyon tanimlama
def kare_toplam(sayilar):
    toplam = 0
    for i in range(len(sayilar)):
        toplam = toplam + sayilar[i]*sayilar[i]
    return toplam


#fonksiyonu calistirmak icin
#sonuc = kare_toplam(sayilar)
sonuc = kare_toplam(sayilar)
print(sonuc)


#en kucuk sayi
def en_kucuk(sayilar):
    kucuk = 999
    for i in range(len(sayilar)):
        if(sayilar[i] < kucuk):
            kucuk = sayilar[i]
    return kucuk

sonuc = en_kucuk([7, 8, 9, 1, 11, 6, 5])
print(sonuc)



#dictionary :sozluk
muhendisler = {'ahmet':12, 'mehmet':14, 'veli':49}

print("ahmetin maasi",muhendisler['ahmet'])
muhendisler['ahmet'] = 33
print("ahmetin maasi",muhendisler['ahmet'])

for isim in muhendisler:
    print("maas",muhendisler[isim])

for isim,maas in muhendisler.items():
    print("isim=", isim, "MAAS=", maas)


def max_salary(employee):
    max = 0
    zengin_isci = ""
    for isim in employee:
        if muhendisler[isim] > max:
            max = muhendisler[isim]
            zengin_isci = isim
    return zengin_isci, max


isim,en_buyuk_maas = max_salary(muhendisler)
print("Zengin isim=", isim, "maas", en_buyuk_maas)


#2-Dimension list (array)
employee = [["Haydarov", "Haydar", 32, 4000], ["Mamaciyali", "Hasari", 50, 3500]]
print(len(employee))
print(len(employee[0]))


print("age=", employee[0][2])

employee = [{"last":"Haydarov", "first:":"Haydar", "age":32, "salary":4000},
            {"last":"Mamaciyali", "first:":"Hasari", "age":50, "salary":3500}]
print(len(employee))

print("age=", employee[0]['age'])
