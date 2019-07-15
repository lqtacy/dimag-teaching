import sys

ALAN_KODLARI_KOD = {}
ALAN_KODLARI_SEHIR = {}

def kodlari_oku(fileName):
    f = open(fileName, "r") #dosyayi ac
    for line in f: #her satir icin
        kod_ve_sehir = line.split("\t")
        kod = kod_ve_sehir[0].strip()
        sehir = kod_ve_sehir[1].strip().lower()
        ALAN_KODLARI_KOD[kod] = sehir
        ALAN_KODLARI_SEHIR[sehir] = kod


def ara_sehir(sehir):
    if sehir in ALAN_KODLARI_SEHIR:
        kod = ALAN_KODLARI_SEHIR[sehir]
        return kod
    else:
        print("Turkiyede boyle bir sehir yok....")
        return None



def ara_kod(kod):
    if kod in ALAN_KODLARI_KOD:
        kod = ALAN_KODLARI_KOD[kod]
        return kod
    else:
        print("Turkiyede boyle bir kod yok....")
        return None


if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Hatali kullanim: python src/main/python/alankodu.py <kod>")
        exit()

    kodlari_oku("./alankodlari.csv")
    #sehir = sys.argv[1].lower()
    kod = sys.argv[1]
    sehir = ara_kod(kod)
    print(sehir)

