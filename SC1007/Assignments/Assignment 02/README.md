# Assignment 02  

## InfixToPrefix:  
Reverse given array and implement postfix;  
Error checking for extra parentheses (() or ()) not required  

## Arithmetic Expression Queue:  
Input #01, #05, #06: Tests "%"  
Input #01 - #06: Tests "(" and ")"  
Input #01, #02, #04, #05, #06: Tests "*"  
Input #01 - #06: Tests "+"  
Input #01 - #06: Tests "-"  
Input #01 - #06: Tests "+"  
Input #01 - #02: Tests "/"  
Input #07: Case when the digit at the end of the input is not printed out. e.g., 1+2 might return 1+ if your code doesn't check for end digit  

## Number of visible pairs:  
To Solve: What I did is to do a for loop and compare the numbers, when I found a matching pair, I check that the pair might have a duplicate pair e.g., 1 2 3 1 4 1 (3,4) and (4,3) can see each other on both sides so we need to take into account of that  

Input #01, #05: Ensure that you check if the size of the input is more than 2, else return the appropriate result  
Input #01, #02, #04, #05: Check that your code does not pair numbers that are not visible in this case - 9 9 6 5 2 4 9 9 should not produce (6,4) since 5 would be blocking it.  
