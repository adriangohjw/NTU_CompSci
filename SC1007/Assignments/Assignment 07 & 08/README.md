# Assignment 07 & 08  

## MCQ
Q01)  Which technique can be used to find the value of F(n)?  
`[All of the mentioned]`

Q02)  What happens when the backtracking algorithm reaches a complete solution?  
`[It continues searching for other possible solutions]`  
When we reach a final solution using a backtracking algorithm, we either stop or continue searching for other possible solutions  
https://qna.talkjarvis.com/3026/what-happens-when-the-backtracking-algorithm-reaches-a-complete-solution  
https://www.sanfoundry.com/backtracking-multiple-choice-questions-answers-mcqs/  

Q03)  Which algorithm cannot find all the solutions if there are many?  
`[Dynamic programming]`  
Problems may have multiple optimal solutions but Dynamic Programming may just return one solution  
https://stackoverflow.com/questions/15437568/how-to-get-all-possible-solutions-using-backtracking-algorithm - means backtracking should be able to find all solutions if there are many?  

Q04)  In what manner is a state-space tree for a backtracking algorithm constructed?  
`[Depth-first search]`  
A state-space tree for a backtracking algorithm is constructed in the manner of depth-first search so that it is easy to look into.  
https://www.sanfoundry.com/backtracking-multiple-choice-questions-answers-mcqs/  

Q05)  When a top-down approach of dynamic programming is applied to a problem, it usually  
`[Decreases the time complexity and increases the space complexity]`  
As the mentioned approach uses the memoization technique it always stores the previously calculated values. Due to this, the time complexity is decreased but the space complexity is increased.  
https://www.geeksforgeeks.org/algorithms-quiz-dynamic-programming-question-8/  

## Recursive Function  
Week 12 Lab Q1, make modifications to the algorithm of top_down_dp() function to match `F(n) = F(n-1) + 2 * F(n-2) - 3 * F(n-3)`  
Create and initialize memory!!!  

## 0/1 Knapsack  
https://medium.com/algorithm-and-datastructure/0-1-knapsack-in-the-bottom-up-approach-cd95adc6791e  
Basically, create a m*n matrix. Using a nested for loop, check if the size of item bigger than current capacity. Map the maximum onto the matrix.  
Create and initialize memory!!! (BE CAREFUL WITH HOW YOU INITIALIZE MEMORY FOR MATRIX)  
Initialize the matrix with all 0's  
I had issues until I realize that s[0] and v[0] doesn't exist...  

## Coloring Problem  
Week 11 Lab Q1, and Q3. Adapt lab Q3 so that it fits lab Q1  
