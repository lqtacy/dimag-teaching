import random

class TowerSampling:
    def __init__(self, actions):
        self.actions = []
        self.probabilities = []
        k = 0
        for action, p in actions.items():
            self.actions.append(action)
            if k > 0:
                self.probabilities.append(p + self.probabilities[k - 1])
            else:
                self.probabilities.append(p)
            k += 1

    def sample(self):
        value = random.random()
        for m in range(len(self.actions)):
            if value <= self.probabilities[m]:
                return self.actions[m]


#------------Testing------------------------
actions = {"walk": 0.3, "sleep": 0.5, "read": 0.10, "watch": 0.10}
sampler = TowerSampling(actions)

actions_freqs = {"walk": 0, "sleep": 0, "read": 0, "watch": 0}
N = 1000000
for i in range(N):
    action = sampler.sample()
    actions_freqs[action] += 1

for key in actions_freqs:
    actions_freqs[key] = actions_freqs[key] / N

print(actions_freqs)
