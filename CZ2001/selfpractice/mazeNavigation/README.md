# Backtracking Application - Navigating Through a Maze

### Objective: 
To walk through a maze containing walls or obstacles from a given entrance to exit, i.e. to find a path, which is a sequence of positions (none blocked) such that each position is N/S/E/W of the previous position.

### Example of Maze used
![alt text](https://github.com/adriangohjw/selfpractice/edit/master/mazeNavigation/image.png)

### Pseudo code

```
Boolean findPath()  {    // find a path from (1, 1) to (m, m)
	position here = (1,1);
	stack s;  // initialised as an empty stack
	mark maze[here] as visited;
	
	while (here is not (m, m))  {
		find an unvisited neighbour to move to;
		if (there is such a neighbour to move to) {
			push here onto the stack s; 
			here = neighbour;
			mark maze[here] as visited;  
		} else {
			if (stack s is empty) return false;
			here = pop(stack s);  // backtrack
		}	
	}
	return true;		
}   
```
