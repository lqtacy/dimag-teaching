import random


def sample(actions_list):
    actions = []
    probabilities = []
    k = 0
    for action, p in actions_list.items():
        actions.append(action)
        if k > 0:
            probabilities.append(p + probabilities[k - 1])
        else:
            probabilities.append(p)

        k += 1

    value = random.random()
    for m in range(len(actions_list)):
        if value <= probabilities[m]:
            return actions[m]


def what_should_do():
    actions = {"walk": 0.3, "sleep": 0.5, "read": 0.10, "watch": 0.10}
    return sample(actions)


actions_freqs = {"walk": 0, "sleep": 0, "read": 0, "watch": 0}
N = 1000000
for i in range(N):
    action = what_should_do()
    actions_freqs[action] += 1

for key in actions_freqs:
    actions_freqs[key] = actions_freqs[key] / N
print(actions_freqs)
