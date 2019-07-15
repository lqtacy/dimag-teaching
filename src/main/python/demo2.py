class Ball():
    def __init__(self, xcord, ycord, t):
        self.x = xcord
        self.y = ycord
        self.pen = t
        self.pen.setposition([self.x, self.y])

    def move(self, n):
        self.pen.forward(n)


#
# b1 = Ball(-100, 0, turtle.Pen())
# b2 = Ball(-100, 100, turtle.Pen())
#
# b1.move(100)
# b2.move(100)
#
#
# time.sleep(40000)


class Student():
    def __init__(this, name, age):
        this.name = name
        this.age = age

    def display(self):
        print(self.name, ":", self.age)

    def incrementAge(self):
        self.age = self.age + 1


s1 = Student("Eyub", 13)
s2 = Student("Yakob", 10)

# s1.display()
# s2.display()

s1.age = 14
# s1.display()
# s2.display()

students = [Student("Eyub", 13), Student("Yakob", 10)]

for s in students:
    s.display()

for s in students:
    s.incrementAge()

for s in students:
    s.display()
