#!/usr/bin/env python3
# Addison Richey 2/10/17
from boxAR import Box
from sphereAR import Sphere
from pyramidAR import Pyramid
t = input("what type of shape do you want to calculate volume and surface area for? \n1. Box \n2. Sphere \n3. Rectangular Pyramid \n")
if (t==1):
    l = input("What is the length of the box? ")
    w = input("What is the width of the box? ")
    h = input("What is the height of the box? ")
    b1 = Box(l,w,h)
    b1.getVolume()
    b1.getSurfaceArea()
    print "the volume of your box is: " , b1.v
    print "the surface area of your box is: ", b1.sa
elif (t==2):
    r = input("What is the radius of the sphere? ")
    s1 = Sphere(r)
    s1.getVolume()
    s1.getSurfaceArea()
    print "the volume of your sphere is: ", s1.v
    print "the surface area of your sphere is: ", s1.sa
elif (t==3):
    l = input("What is the length of the base of the pyramid? ")
    w = input("What is the width of the base of the pyramid? ")
    h = input("What is the height of the pyramid? ")
    p1 = Pyramid(l,w,h)
    p1.getVolume()
    p1.getSurfaceArea()
    print "the volume of your pyramid is: ", p1.v
    print "the surface area of your pyramid is: ", p1.sa
else:
    print "Sorry, invalid answer."
