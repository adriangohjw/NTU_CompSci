## Assignment 05  

## MCQ:  
#### Q01:  
`h(key) = key mod 3`  
`input = 3, 6, 5, 10, 12, 14, 16`  

`0  |  12 -> 6 -> 3 ->`  
`1  |  16 -> 10 ->`  
`2  |  14 -> 5 -> `  

#### Answer: 3  

#### Q02:  
`1st slot: 8 + (0 * -2) = 8`  
`2nd slot: 8 + (1 * -2) = 6`  
`3rd slot: 8 + (2 * -2) = 4`  

#### Answer: Slot 8, Slot 6, Slot 4  

#### Q03:  
`1st slot: 8 + (0 * 2) = 8`  
`2nd slot: 8 + (1 * 2) = 10`  
`3rd slot: 8 + (2 * 2) = 12`  

#### Answer: Slot 8, Slot 10, Slot 12

#### Q04:

`Since there is no path from 5 to another node, it is not strongly connected`  

#### Answer: No  

#### Q05:  

#### Answer: If the number of vertices is more than 2, a complete graph is also a cyclic graph.  


## Graph: Degree of a Vertex  
Similar to Lab, but instead they tell you to find degree using matrix. Lab tells you to use list.  
To solve, try to use a nested loop to search through the matrix  
For test cases idk what to look out for. It should work if your implementation of nested loop is ok.  

## Graph Representation: Adjacency list to Adjacency matrix  
You may need to insert:  

    for(int i = 0; i < g.V; i++){
        g.adj.list[i] = NULL;
    }

into line 43 of the code for it to work. Idk why mine don't need on hackerearth but on VSCode I need that code snippet...  

For this, you need to allocate memory for the matrix (see lab on how they allocate)  
Then, loop through the adj.list using a for loop, check if g->adj.list[i] is null. If null then i++.  
For test cases idk what to look out for.  

## Hash Table: Delete a key  
Contains the idea of both HashInsert and HashSearch.  
Inputs #03, #04, #05 - Checks if the first node is deleted  e.g. (7 -> 4 -> 1 if 7 is to be removed the final hash table should be 4 -> 1).  
