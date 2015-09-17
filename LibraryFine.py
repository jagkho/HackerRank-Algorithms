__author__ = 'PrateekMehrotra'
import sys
from datetime import date
d1 = input()
d2 = input()
d1Split = d1.split(' ')
d2Split = d2.split(' ')
if (d1Split[0] <= d2Split[0] and d1Split[1] <= d2Split[1] and d1Split[2] <= d2Split[2]) or (d1Split[1] < d2Split[1] and d1Split[2] <= d2Split[2]) or (d1Split[2] < d2Split[2]):
    print(0)
else:
    if d1Split[0] != d2Split[0] and d1Split[1] == d2Split[1] and d1Split[2] == d2Split[2]:
        diff = int(d1Split[0]) - int(d2Split[0])
        print(diff*15)
    elif d1Split[0] != d2Split[0] and d1Split[1] != d2Split[1] and d1Split[2] == d2Split[2]:
        diff = abs(int(d1Split[1]) - int(d2Split[1]))
        print(diff*500)
    else:
        print(10000)

