import random


def yazitura(N):
    yazi = 0
    tura = 0
    for i in range(N):
        rakam = random.random()  # deneme
        if rakam < .5:
            yazi = yazi + 1
        else:
            tura = tura + 1
    return yazi / N, tura / N


yazi, tura = yazitura(2000)
print("Yazi:", yazi)
print("Tura:", tura)
