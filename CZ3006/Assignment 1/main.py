import matplotlib.pyplot as plt
from math import exp

p = 0.1
a = 0.03

def plot_aloha(G):
    s = G * exp(-2*G)
    return s


def plot_aloha_slotted(G):
    s = G * exp(-1*G)
    return s


def plot_nonpersistent_csma(G, a):
    x = exp(-1*a*G)
    num = G * x
    denom = G*(1+2*a) + x
    s = num/denom
    return s


def plot_1_persistent_csma(G, a):
    num = G * (1 + G + a*G*(1 + G + a*G/2)) * exp(-1*G*(1+2*a))
    denom = G*(1 + 2*a) - (1 - exp(-1*a*G)) + (1 + a*G)*(exp(-1*(1+a)))
    s = num/denom
    return s

# Range
Range = [i*0.01 for i in range(1,10000)]

# adding the plotted points
list_pureAloha = [plot_aloha(i) for i in Range]
list_slottedAloha = [plot_aloha_slotted(i) for i in Range]
list_nonPersistentCSMA = [plot_nonpersistent_csma(i,a) for i in Range]
list_1PersistentCSMA = [plot_1_persistent_csma(i,a) for i in Range]

# plotting points on the grap
plt.plot(Range, list_pureAloha, label='Pure Aloha')
plt.plot(Range, list_slottedAloha, label='Slotted Aloha')
plt.plot(Range, list_nonPersistentCSMA, label = 'NP CSMA')
plt.plot(Range, list_1PersistentCSMA, label='1P CSMA')

# set graph to logarithm scale
plt.xscale('log')
plt.xlabel("G")
plt.ylabel("S")
plt.ylim(bottom=0, top=1)
ax = plt.gca()
plt.legend()
plt.show()
