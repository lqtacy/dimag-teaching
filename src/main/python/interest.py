def calculate_interest(base_money, rate, years):
    return base_money * pow(1.0 + rate, years)


results = []
for i in range(1, 30):
    total = calculate_interest(100.0, 0.08, i)
    results.append(total)

print(results)

# list comprehension
results = [calculate_interest(100, 0.08, y) for y in range(1, 30)]
print(results)


#closure
def interest_calculator(base_money, rate):
    return lambda year: base_money * pow(1.0 + rate, year)

calculator = interest_calculator(100, 0.08)
for i in range(1, 30):
    print(calculator(i))


#closure
def interest_calculator2(base_money, rate):
    def calculator (year):
        return base_money * pow(1.0 + rate, year)

    return calculator


calculator = interest_calculator2(100, 0.08)
for i in range(1, 30):
    print(calculator(i))
