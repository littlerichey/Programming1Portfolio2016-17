#!/usr/bin/env python3
fvowel = False
hitvowel = False
word = input('word: ')
char = 0
while (hitvowel == False):
    if (char > 0):
        if (word[char] == 'a' or word[char] == 'e' or word[char] == 'i' or word[char] == 'o' or word[char] == 'u' or word[char] == 'y'):
            addon = word[:char]
            word = word[(char):] + addon + "ay"
            hitvowel = True    
    elif (word[char] == 'a' or word[char] == 'e' or word[char] == 'i' or word[char] == 'o' or word[char] == 'u'):
        word = word + "way"
        hitvowel = True
    char += 1 
    
print word   
    
