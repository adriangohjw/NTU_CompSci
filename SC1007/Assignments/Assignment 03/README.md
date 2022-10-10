# Assignment 03  

## MCQ  
https://www.geeksforgeeks.org/gate-gate-cs-1996-question-38/  
https://iq.opengenus.org/time-complexity-of-binary-search/  

## Construct A Binary Tree  
Inputs #01, #03 - Checks for error handling for 1 char in the pre-order and post-order  
Inputs #02, #04, #05 - It's either Runtime Error or it just accepts for me  
Inputs #06 - Tbh idk what this tests for, but when I use malloc to create string it doesn't work for some reason. I resulted in using char var[MAX_N] instead  

Resources Used:  
https://www.youtube.com/watch?v=5lWJpTEnyow  


## The Moving Cost from A to B in a Binary Tree  
General Wrong answer: Check that you have check if node->left and node->right is null just return don't keep on doing recursion.  
Inputs #02 - Looks like this is testing 1 value is the lowest common ancestor of both values.  
Inputs #04 - Looks like this is testing if nodeV1 and nodeV2 is the same value  

Resources Used:  
https://www.youtube.com/watch?v=13m9ZCB8gjw  


## Expression Tree  
Inputs #02, #03 - Check if you used double for assignment instead of int (e.g., double leftNodeNum, rightNodeNum)  
Inputs #05 - Single spaced characters instead of double spaced characters  
General Runtime error - If all test cases return runtime error, check if you assigned memory in the createExpressionTree function (e.g., *root = malloc(sizeof(BTNode));  

Resources Used:  
https://stackoverflow.com/questions/66828074/creating-a-recursive-function-that-creates-a-expression-tree-from-a-prefix-expre  
https://www.youtube.com/watch?v=2tpcqDmvJBU  
