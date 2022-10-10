# Python3 Hangman Game

# Add "random" and "sleep" function into program
import random
from time import sleep

# Define how to output the hang man figure
HANGMAN = (
"""
 ------
 |    |
 |
 |
 |
 |
 |
 |
 |
----------
""",
"""
 ------
 |    |
 |    O
 |
 |
 |
 |
 |
 |
----------
""",
"""
 ------
 |    |
 |    O
 |   -+-
 | 
 |   
 |   
 |   
 |   
----------
""",
"""
 ------
 |    |
 |    O
 |  /-+-
 |   
 |   
 |   
 |   
 |   
----------
""",
"""
 ------
 |    |
 |    O
 |  /-+-/
 |   
 |   
 |   
 |   
 |   
----------
""",
"""
 ------
 |    |
 |    O
 |  /-+-/
 |    |
 |   
 |   
 |   
 |   
----------
""",
"""
 ------
 |    |
 |    O
 |  /-+-/
 |    |
 |    |
 |   | 
 |   | 
 |   
----------
""",
"""
 ------
 |    |
 |    O
 |  /-+-/
 |    |
 |    |
 |   | |
 |   | |
 |  
----------
""")

WORDS = ("CODE", "ARTIFICIAL")
#WORDS = ("ARTIFICIAL")
word = random.choice(WORDS)
POSITIVE_SAYINGS = ("Well done!", "Awesome!", "You Legend!")

#MAX_WRONG = len(word) - 1
if len(word) > len(HANGMAN):
    MAX_WRONG = len(HANGMAN)
else:
    MAX_WRONG = len(word) - 1
 
so_far = ("-") * len(word)
used = []
wrong = 0

print("\t \t Welcome to Hangman!")
print()
input("Press Enter to START: ")

# main guessing portion
while wrong < MAX_WRONG and so_far != word:
    print()
    print(HANGMAN[wrong])
    print("Word so far: ", so_far)
    print("Letters used: ", used)

    guess = input("Guess a letter: ").upper()
    sleep(1) # Time delay - allows userfriendly reading
    print()

    while guess in used:
        print("Try again... You've already used this letter")
        guess = input("Guess a letter: ").upper()
        sleep(1)
        print()
    used.append(guess)

    if guess in word:
        print(random.choice(POSITIVE_SAYINGS),"...Updating word so far...")

        new = ""
        for i in range(len(word)):
            if guess == word[i]:
                new += guess

            else:
                new += so_far[i]
        so_far = new 

    else:
        print("INCORRECT! Try again!")
        wrong += 1

# End of game, next few lines of codes will print game result and quit game
print("Calculating result...")
sleep(1)

if wrong == MAX_WRONG:
    print("UNLUCKY! Better luck next time!")
    print("The word is {}".format(word))

else:
    print("WINNER! Congratulations!")
    print("The word is {}".format(word))

print()
print()
input("Press Enter to Leave: ")
