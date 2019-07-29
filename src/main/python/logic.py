# kurban: dana,
# sart 1: yasi  2 ile 4 arasi
# sart ne cok buyuk ne cok kucuk (500 kg,  3000 kg) -->1000-1500
# rengi ya sari yada siyah
# hasta olmasin

#
# if (yas >= 2 and yas <=4) and (kilo >=1000 and kilo <= 1500) and (renk=='sari' or renk=='siyah') and (not hasta):
#     print("kurbanliga uygundur.")
# else:
#     print("Uygun degil")


def kurbanlik(yas, kilo, renk, hasta):
    uygun = True
    message = ""
    if not (yas >= 2 and yas <= 4):
        uygun = False
        message = "yas 2 ile 4 arasi degildir. "

    if not (kilo >= 1000 and kilo <= 1500):
        uygun = False
        message = message + "kilo 1000 ile 1500 arasi degildir. "

    if not (renk == 'sari' or renk == 'siyah'):
        uygun = False
        message = message + "renk sari veya siyah degildir"

    if hasta:
        uygun = False
        message = message + "hastadir..."

    return uygun, message

kilo = "66"

yas = int(input("yasi kac?"))
kilo = int(input("kilosu kac?"))

renk = input("Rengi nedir?")
hastamidir = input("hasta midir?")
hasta = False

hastamidir = hastamidir.lower()
if hastamidir =='evet':
    hasta = True


uygun, message = kurbanlik(yas, kilo, renk, hasta)

if uygun:
    print("Uygundur...")
else:
    print("Uygun degildir. Cunku, ", message)


