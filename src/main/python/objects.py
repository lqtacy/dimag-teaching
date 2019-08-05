# object-oriented
class Employee():
    def __init__(self, first, last, age, salary):
        self.first_name = first
        self.last_name = last  # sifatlari
        self.age = age
        self.salary = salary

    def __str__(self):
        return "Firstname:" + self.first_name + " Age:" + str(self.age) + " salary:" + str(self.salary)

    def hello(self):
        print("Hello ", self.first_name, " ", self.last_name)

def abc():
    return "hello"

emp = Employee('Haydarov', 'Haydar', 32, 4000)
emp2 = Employee('Haydarov2', 'Haydar2', 33, 3000)
#print(emp.age)
#print(emp2.age)

employee = [emp, emp2]

#print("age=", employee[0].age)

#emp.hello()
#emp2.hello()


for e in employee:
    e.hello()