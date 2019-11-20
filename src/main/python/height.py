def height(base_height):
    def h(distance):
        return distance / 2.0 + base_height

    return h


# closure
def height2(base_height):
    return lambda distance: distance / 2.0 + base_height


hf = height(1000)

for h in range(200, 2000, 50):
    print(h, "=", hf(h))


def incrementer(base_value):
    total = {"total": base_value}

    def inc(v):
        total["total"] = total["total"] + v
        return total["total"]
    return inc


inc = incrementer(900)

for i in range(10):
    print(inc(2))
