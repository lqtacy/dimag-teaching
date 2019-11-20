class Student:
    def __init__(self, isim, dogum_ayi):
        self.name = isim
        self.birthday = dogum_ayi

    def __str__(self):
        return "name:" + self.name + ", birthday:" + self.birthday