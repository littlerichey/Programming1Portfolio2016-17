#!/usr/bin/env python3
#Addison Richey 2/10/17
class Pyramid:
    def __init__(self, l, w, h):
        self.l = l
        self.w = w
        self.h = h
        self.v = 0
        self.sa = 0
    def getVolume(self):
        self.v = (self.l*self.w*self.h)/3
 
    def getSurfaceArea(self):
        import math
        l = self.l
        w = self.w
        h = self.h
        self.sa = (l*w) + (l*pow((pow((w/2),2)+pow(h,2)),(.5))) + (w*pow((pow((l/2),2)+pow(h,2)),(.5)))


    
