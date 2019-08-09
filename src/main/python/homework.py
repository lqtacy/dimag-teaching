# Import smtplib for the actual sending function
import smtplib
from email.message import EmailMessage


#object-oriented
class Employee:
    def __init__(self, first, last, age, salary):
        self.first_name = first
        self.last_name = last  # sifatlari
        self.age = age
        self.salary = salary


ex = Employee("Zarif", "Zarifoglu", 12, 3500)

def read_employee(file_name):
    employee_list = []
    file = open(file_name, "r") #dosyayi ac
    for line in file: #her satir icin
        degerler = line.split(",")
        employee = Employee(degerler[1], degerler[0], degerler[2], degerler[3])
        employee_list.append(employee)

    return employee_list


def read_employee_dict(file_name):
    employee_list = []
    file = open(file_name, "r") #dosyayi ac
    for line in file: #her satir icin
        degerler = line.split(",")
        employee = {"first_name": degerler[1], "last_name":degerler[0], "age":degerler[2], "salary":degerler[3]}
        employee_list.append(employee)

    return employee_list



employees = read_employee("/Users/htosun/dev/dimag/dimag-teaching/employee.csv")

for e in employees:
    print(e.first_name, " ", e.last_name)



employees = read_employee_dict("/Users/htosun/dev/dimag/dimag-teaching/employee.csv")

for e in employees:
    print(e["first_name"], " ", e["last_name"])


class Araba:
    def __init__(ben, rengi, hizi, model):
        ben.color = rengi
        ben.speed = hizi
        ben.model = model

    def display(ben):
        print("Araba:", ben.model, " hizi:", ben.speed)

    def speed_in_miles(self):
        return self.speed/1.6




ahmetin_arabasi = Araba("kirmizi", 300, "tesla")

ahmetin_arabasi.display()

print(ahmetin_arabasi.speed_in_miles())


class User: #kullanici
    def __init__(self, adi, soyadi, email_adresi, sifre):
        self.adi = adi
        self.soyadi = soyadi
        self.email_adresi = email_adresi
        self.sifre = sifre





def send_email(kullanici, baslik, from_email, body):
    print("from:", from_email)
    print("to:", kullanici.email_adresi)
    print("body:", body)

    msg = EmailMessage()

    # me == the sender's email address
    # you == the recipient's email address
    msg['Subject'] = baslik
    msg['From'] = from_email
    msg['To'] = kullanici.email_adresi
    msg['Body'] = body
    # Send the message via our own SMTP server.
    s = smtplib.SMTP('localhost')
    s.send_message(msg)
    s.quit()


zeki_kulanici = User("Ramazan", "Ramazanov", "ramazan.ramazanov@gmail.com", "qilavinli_koko_123")

print(zeki_kulanici.email_adresi)

#send_email(zeki_kulanici, "Merhaba arkadas....", "hasari@gmail.com", "merhaba Ramazanov...")




class Ogrenci:
    def __init__(self, adi, soyadi, email_adresi, yas, sinif):
        self.adi = adi
        self.soyadi = soyadi
        self.email_adresi = email_adresi
        self.yas = yas
        self.sinif = sinif
        self.dersler = []

    def ders_ekle(self, ders):
        self.dersler.append(ders)





o1 = Ogrenci("Zarif", "Zarifoglu", "zarif@zarif.com", 11, 6)
o1.ders_ekle("Guzel sanatlar")
o1.ders_ekle("Astronomi")
o1.ders_ekle("Artificial Intelligence")




for d in o1.dersler:
    print(d)
