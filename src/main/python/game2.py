import random


def guess():
    gizli = random.randint(1, 100)
    for deneme in range(10):
        tahmin = int(input("Tahmin et:"))  # sonucu string. Sayiya cevirmek icin int() kullanmamiz lazim
        if tahmin == gizli:
            print("Bravo! Dogru tahmin ettin. Deneme sayisi:", deneme + 1)
            break

        if tahmin < gizli:
            print("Daha buyuk...")
        else:
            print ("Daha kucuk...")

        if deneme == 9:
            print("Daha fazla zeythin yagi ic...")


play = input("Hosgeldiginiz! Numara tahmini oyununu oynamak istermisiniz?").lower()

while play != "h":
    guess()
    play = input("Bir daha oynamak istermisiniz? Hayir icin H yazin").lower()

print("Oynadiginiz icin tesekkur ederim.")