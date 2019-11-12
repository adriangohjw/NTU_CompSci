import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

public class BreadthFirstSearch {
	private static ArrayList<Vertex> shortestRoute = new ArrayList<Vertex>(); //List that holds the results with shortest route
	private static Queue <Vertex> queue = new LinkedList <Vertex>();
	private static HashMap<Vertex, Integer> tree = new HashMap<Vertex, Integer>();

	public static ArrayList<Vertex> bfs (Graph g, Vertex originCity, Vertex destCity){
		Vertex vertex;
		LinkedList<Vertex> adjVertices;
		int distance = 1; //Initialize as 1 to indicate starting -- keep track how far it is from start
		
		//starting vertex:
		queue.add(originCity); //add root to empty queue
		originCity.setAsVisited();
		tree.put(originCity, distance); //key= originCity, value = distance
		
		if(originCity.getCity().equals(destCity.getCity())) //there is only one vertex
			return null;
		
		while(!queue.isEmpty()) {
			vertex = queue.remove();
			adjVertices = g.getAdjVertices(vertex); //get the neighbour of the vertex

			distance = tree.get(vertex)+1; //gets the key of Vertex v & add 1
			for(Vertex neighbour: adjVertices) { //for each neighbours
				if(!neighbour.getVisited()) {
					neighbour.setAsVisited();
					queue.add(neighbour);
					tree.put(neighbour, distance);
				}
			}
		}
		
		Vertex pointer = destCity; //target node
		shortestRoute.add(destCity); 
		//traverse to find the path back to the starting node
		while(pointer!=null && !(pointer.getCity().equals(originCity.getCity()))) {
			for (Vertex key : tree.keySet() ) { //traverse each key of the Map
				pointer = shortestRoute.get(shortestRoute.size()-1); //points to the recent val added

				if(pointer.getCity().equals(originCity.getCity()))
					break;

				if(g.isAdjVertices(key, pointer)&&(tree.get(key).intValue() == (tree.get(pointer).intValue()-1))) //if they are neighbours
					shortestRoute.add(key);
				
			}
		}
		return shortestRoute;
	}
	

}
