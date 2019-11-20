import time


# dynamically typed: python, javascript, perl, php, Lisp
# statically typed: Java, Go, C#, C, C++
class TimeEvent:
    def __init__(self, name):
        self.start_time = time.time()
        self.name = name


class TimeFunction:
    def __init__(self):
        self.event_statck = []

    def start(self, name):
        e = TimeEvent(name)
        self.event_statck.append(e)

    def time(self):
        e = self.event_statck.pop()
        elapsed = time.time() - e.start_time
        print(e.name, " took ", elapsed, " ns")


def f(n):
    toplam = 0
    for i in range(n + 1):
        toplam = toplam + i
    return toplam


# recursion (tail recursion)
def g(n):
    if n == 0:
        return 0
    else:
        return n + g(n - 1)


t = TimeFunction()
t.start("f")
print(f(500))
t.time()

t.start("g")
print(g(500))
t.time()
