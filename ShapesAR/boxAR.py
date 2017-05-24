#!/usr/bin/env python3
#Addison Richey 2/10/17
class Box:
    def __init__(self, l, w, h):
        self.l = l
        self.w = w
        self.h = h
        self.v = 0
        self.sa = 0
    def getVolume(self):
        self.v = self.l*self.w*self.h
    def getSurfaceArea(self):
        self.sa = ((self.l*self.w)+(self.l*self.h)+(self.w*self.h))*2
    



