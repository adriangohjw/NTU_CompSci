import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;

public class Graph {
	private LinkedHashMap<Vertex, LinkedList<Vertex>> adjVertices; //key: vertex, value: linkedList of adjacent vertices
	private static LinkedHashMap<String, Vertex> myVertices; //key: city name, value: Vertex with corresponding city name

	private int myNumVertices;
	private int myNumEdges;

	public Graph() {
		adjVertices = new LinkedHashMap<Vertex, LinkedList<Vertex>>(); // initialise 
		myVertices = new LinkedHashMap<String, Vertex>(); //initialise
		myNumVertices = myNumEdges = 0;
	}

	public Vertex addVertex(String city) {
		Vertex v;
		v = myVertices.get(city);
		if (v == null) { //if there is no such vertex
			v = new Vertex (city); //create vertex with city name
			myVertices.put(city, v);
			adjVertices.put(v, new LinkedList<Vertex>());
			myNumVertices ++;
		}
		return v;
	}
	
	public static Vertex getVertex(String city) { //return vertex given vertex city name (key)
		return myVertices.get(city);
	}
	
	public boolean hasVertex(String city) {
		return myVertices.containsKey(city); //check if vertex with city name already exist
	}
	
	public boolean hasEdge(String origin, String dest) {
		if(!hasVertex(origin) || !hasVertex(dest)) //if there is no such vertex, return false
			return false;
		return adjVertices.get(myVertices.get(origin)).contains(myVertices.get(dest));
	}
	
	public void addEdge (String origin, String dest) {
		Vertex o, d;
		if(hasEdge(origin, dest))
			return;
		myNumEdges++;
		if((o = getVertex(origin))==null)
			o = addVertex(origin);
		if((d = getVertex(dest))==null)
			d = addVertex(dest);
		adjVertices.get(o).add(d); 
		adjVertices.get(d).add(o);
	}

	void removeVertex(String label) {
		Vertex v = new Vertex(label);
		adjVertices.values().stream().forEach(e -> e.remove(v));
		adjVertices.remove(new Vertex(label));
	}

	
	public LinkedList<Vertex> getAdjVertices(Vertex vertex){ //return adjacency list of vertex given vertex key
		return adjVertices.get(vertex);
	}
	
	public boolean isAdjVertices(Vertex v, Vertex w) {
		return (adjVertices.get(v).contains(w) || adjVertices.get(w).contains(v));
	}

	public int getNumVertices()
	{
		return myNumVertices;
	}
	
	public int getNumEdges()
	{
		return myNumEdges;
	}
	
	public String printGraph()
    {
		String s = "";
		Set<Vertex> keys = adjVertices.keySet();
		for(Vertex vertex: keys) {
			s+=(vertex.getCity() + ": ");
			for(Vertex ver: adjVertices.get(vertex)) {
				if(adjVertices.get(vertex).getLast().equals(ver)) {
					s+=(ver.getCity());
				}
				else {
					s+=(ver.getCity() + ", ");
				}
			}
			s += "\n";
		}
		return s;
    	 
    }



}
