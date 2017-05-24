#!/usr/bin/env python3
#Addison Richey 2/10/17
class Sphere:
    def __init__(self, r):
        self.r = r
        self.v = 0
        self.sa = 0
    def getVolume(self):
        import math
        self.v = ((4 * math.pi) / 3) * math.pow(self.r,3)
    def getSurfaceArea(self):
        import math
        self.sa = 4 * math.pi * math.pow(self.r,2)

