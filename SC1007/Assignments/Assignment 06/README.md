# Assignment 06

## Graph Connection (Undirected graph)  
Very similar to lab Q2. We have to compare the number of visited nodes to the total number of vertices.  
Inputs #02, #04 - In my case, I added a if condition that checks whether the total number of vertices is more than 0 before running the DFS  

## Shortest Distances  
I used lab Q1 for the BFS  
There are many methods to solve (I think?), but what I did is to create an array to store distances between the start node and all the other nodes. First I initialize the array to -1 for all values. Then through BFS, at the part where they mark g.visited[i]=1. I assign the distance of i to be distance of the parent node + 1. Check if end node value smaller than total vertices then return distance of the end node.  

![image](https://user-images.githubusercontent.com/32679064/194700588-f025fffa-9080-40b1-92fe-835e87c7b2e5.png)

## Graph Connection (Directed Graph)  
Almost exactly the same as [Graph Connection (Undirected graph)]. You will need to loop through and use every vertex as the beginning vertex to start search.  
Inputs #03 - I got that when I copied-pasted my code from [Graph Connection (Undirected graph)]. Most likely you need to search every node. Idk why the rest passed.  
