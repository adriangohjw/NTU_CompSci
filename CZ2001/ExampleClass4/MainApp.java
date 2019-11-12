import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		Graph G = new Graph();
		Scanner sc = new Scanner(System.in);

		System.out.println("1. Size 10 with less edges");
		System.out.println("2. Size 10 with more edges");
		System.out.println("3. Size 15 with less edges");
		System.out.println("4. Size 15 with more edges");
		System.out.println("5. Size 20 with less edges");
		System.out.println("6. Size 20 with more edges");

		//size- max number of edges from one place to the other
		System.out.println("Enter size of graph option(1, 2, 3, 4, 5 or 6): ");
		int choice = sc.nextInt();		
		dataPopulation(G, choice);
		// print out graph
		System.out.println(G.printGraph());
		String dummychar = sc.nextLine();

		String originCity = "", destCity = "";
		sc = new Scanner(System.in);

		System.out.print("Enter origin city: ");
		originCity = sc.nextLine();
		System.out.print("Enter destination city: ");
		destCity = sc.nextLine();
		System.out.println("");

		Vertex s = Graph.getVertex(originCity);
		Vertex e = Graph.getVertex(destCity);
		long startTime = System.nanoTime();
		ArrayList<Vertex> shortestPath = BreadthFirstSearch.bfs(G, s, e);

		long estimatedTime = System.nanoTime() - startTime;

		System.out.println("CPU time taken for BFS: " + estimatedTime + "\n");
		
		System.out.println("No of Vertices: " + G.getNumVertices());
		System.out.println("No of Edges: " + G.getNumEdges());

		if ((shortestPath.size() - 1) > 1) {
			for (int i = shortestPath.size() - 1; i > 0; i--) {
				System.out.print(shortestPath.get(i).getCity() + " to ");
			}
			System.out.println(destCity);
			System.out.println("Smallest possible number of stops" + " from " + originCity + " to " + destCity + " is "
					+ (shortestPath.size() - 2) + " stops.");
		} else {
			System.out.println(originCity + " to " + destCity);
			System.out.println(
					"Non-stop flight available from departure city " + originCity + " to arrival city " + destCity);
		}

	}

	public static void dataPopulation(Graph G, int choice) {

		switch (choice) {
		case 1: 
			G.addEdge("LA", "Seoul");
			G.addEdge("LA", "Tokyo");
			//G.addEdge("Seoul", "Singapore");
			G.addEdge("Seoul", "Shanghai");
			G.addEdge("Seoul", "Tokyo");
			G.addEdge("Singapore", "Hong Kong");
			G.addEdge("Singapore", "Sydney");
			G.addEdge("Singapore", "Tokyo");
			//G.addEdge("Singapore", "Shanghai");
			G.addEdge("Singapore", "Beijing");
			G.addEdge("Sydney", "KL");
			G.addEdge("Hong Kong", "Shanghai");
			//G.addEdge("Hong Kong", "Beijing");	
			//G.addEdge("Shanghai", "Tokyo");
			G.addEdge("Shanghai", "Beijing");
			G.addEdge("Beijing", "Tokyo");
			G.addEdge("Chicago", "Perth");
			G.addEdge("Chicago", "KL");
			break;
		case 2:
			G.addEdge("LA", "Seoul");
			G.addEdge("LA", "Tokyo");
			G.addEdge("Seoul", "Singapore");
			G.addEdge("Seoul", "Shanghai");
			G.addEdge("Seoul", "Tokyo");
			G.addEdge("Singapore", "Hong Kong");
			G.addEdge("Singapore", "Sydney");
			G.addEdge("Singapore", "Tokyo");
			G.addEdge("Singapore", "Shanghai");
			G.addEdge("Singapore", "Beijing");
			G.addEdge("Sydney", "KL");
			G.addEdge("Hong Kong", "Shanghai");
			G.addEdge("Hong Kong", "Beijing");	
			G.addEdge("Shanghai", "Tokyo");
			G.addEdge("Shanghai", "Beijing");
			G.addEdge("Beijing", "Tokyo");
			G.addEdge("Chicago", "Perth");
			G.addEdge("Chicago", "KL");
			break;
			
		case 3:
			G.addEdge("LA", "Seoul");
			G.addEdge("LA", "Tokyo");
			G.addEdge("LA", "Paris");
			//G.addEdge("Seoul", "Singapore");
			G.addEdge("Seoul", "Shanghai");
			//G.addEdge("Seoul", "Tokyo");
			G.addEdge("Singapore", "Hong Kong");
			G.addEdge("Singapore", "Sydney");
			G.addEdge("Singapore", "Tokyo");
			//G.addEdge("Singapore", "Shanghai");
			G.addEdge("Singapore", "Beijing");
			G.addEdge("Singapore", "Mumbai");
			G.addEdge("Sydney", "KL");
			G.addEdge("Sydney", "Paris");
			G.addEdge("Hong Kong", "Shanghai");
			//G.addEdge("Hong Kong", "Beijing");
			G.addEdge("Hong Kong", "Atlanta");
			G.addEdge("Hong Kong", "New York");
			//G.addEdge("Shanghai", "Tokyo");
			G.addEdge("Shanghai", "Beijing");
			G.addEdge("Beijing", "Tokyo");
			G.addEdge("Tokyo", "Mumbai");
			G.addEdge("Chicago", "Perth");
			//G.addEdge("Chicago", "KL");
			G.addEdge("Chicago", "Mumbai");
			G.addEdge("Perth", "Atlanta");
			G.addEdge("Atlanta", "Irvine");
			G.addEdge("Irvine", "Mumbai");
			G.addEdge("Irvine", "Paris");
			break;
		case 4: 
			G.addEdge("LA", "Seoul");
			G.addEdge("LA", "Tokyo");
			G.addEdge("LA", "Paris");
			G.addEdge("Seoul", "Singapore");
			G.addEdge("Seoul", "Shanghai");
			G.addEdge("Seoul", "Tokyo");
			G.addEdge("Singapore", "Hong Kong");
			G.addEdge("Singapore", "Sydney");
			G.addEdge("Singapore", "Tokyo");
			G.addEdge("Singapore", "Shanghai");
			G.addEdge("Singapore", "Beijing");
			G.addEdge("Singapore", "Seoul");
			G.addEdge("Singapore", "Mumbai");
			G.addEdge("Sydney", "KL");
			G.addEdge("Sydney", "Paris");
			G.addEdge("Hong Kong", "Shanghai");
			G.addEdge("Hong Kong", "Beijing");
			G.addEdge("Hong Kong", "Atlanta");
			G.addEdge("Hong Kong", "New York");
			G.addEdge("Shanghai", "Tokyo");
			G.addEdge("Shanghai", "Beijing");
			G.addEdge("Beijing", "Tokyo");
			G.addEdge("Tokyo", "Mumbai");
			G.addEdge("Chicago", "Perth");
			G.addEdge("Chicago", "KL");
			G.addEdge("Chicago", "Mumbai");
			G.addEdge("Perth", "Atlanta");
			G.addEdge("Atlanta", "Irvine");
			G.addEdge("Irvine", "Mumbai");
			G.addEdge("Irvine", "Paris");
			break;
			
		case 5:
			G.addEdge("LA", "Seoul");
			G.addEdge("LA", "Tokyo");
			G.addEdge("LA", "Paris");
			//G.addEdge("Seoul", "Singapore");
			G.addEdge("Seoul", "Shanghai");
			//G.addEdge("Seoul", "Tokyo");	
			G.addEdge("Singapore", "Hong Kong");
			//G.addEdge("Singapore", "Sydney");
			G.addEdge("Singapore", "Tokyo");
			//G.addEdge("Singapore", "Shanghai");
			G.addEdge("Singapore", "Beijing");
			G.addEdge("Singapore", "Seoul");
			G.addEdge("Singapore", "Mumbai");
			G.addEdge("Sydney", "KL");
			G.addEdge("Sydney", "Paris");
			G.addEdge("Sydney", "Venice");
			G.addEdge("Hong Kong", "Shanghai");
			//G.addEdge("Hong Kong", "Beijing");
			G.addEdge("Hong Kong", "Atlanta");
			G.addEdge("Hong Kong", "New York");	
			//G.addEdge("Shanghai", "Tokyo");
			G.addEdge("Shanghai", "Beijing");
			G.addEdge("Beijing", "Tokyo");
			G.addEdge("Beijing", "Athens");
			G.addEdge("Tokyo", "Mumbai");
			G.addEdge("Chicago", "Perth");
			//G.addEdge("Chicago", "KL");
			G.addEdge("Chicago", "Mumbai");
			G.addEdge("KL", "Venice");
			G.addEdge("KL", "Athens");
			//G.addEdge("Perth", "Atlanta");
			G.addEdge("Perth", "Venice");
			G.addEdge("Perth", "Barcelona");	
			G.addEdge("Atlanta", "Irvine");
			G.addEdge("Atlanta", "Athens");
			G.addEdge("Irvine", "Mumbai");
			G.addEdge("Irvine", "Paris");
			G.addEdge("Irvine", "Athens");
			G.addEdge("Mumbai", "Doha");
			G.addEdge("Paris", "Doha");
			G.addEdge("New York", "Doha");
			G.addEdge("New York", "Amsterdam");
			G.addEdge("Amsterdam", "Barcelona");
			break;		
		case 6:
			G.addEdge("LA", "Seoul");
			G.addEdge("LA", "Tokyo");
			G.addEdge("LA", "Paris");
			G.addEdge("Seoul", "Singapore");
			G.addEdge("Seoul", "Shanghai");
			G.addEdge("Seoul", "Tokyo");	
			G.addEdge("Singapore", "Hong Kong");
			G.addEdge("Singapore", "Sydney");
			G.addEdge("Singapore", "Tokyo");
			G.addEdge("Singapore", "Shanghai");
			G.addEdge("Singapore", "Beijing");
			G.addEdge("Singapore", "Seoul");
			G.addEdge("Singapore", "Mumbai");
			G.addEdge("Sydney", "KL");
			G.addEdge("Sydney", "Paris");
			G.addEdge("Sydney", "Venice");
			G.addEdge("Hong Kong", "Shanghai");
			G.addEdge("Hong Kong", "Beijing");
			G.addEdge("Hong Kong", "Atlanta");
			G.addEdge("Hong Kong", "New York");	
			G.addEdge("Shanghai", "Tokyo");
			G.addEdge("Shanghai", "Beijing");
			G.addEdge("Beijing", "Tokyo");
			G.addEdge("Beijing", "Athens");
			G.addEdge("Tokyo", "Mumbai");
			G.addEdge("Chicago", "Perth");
			G.addEdge("Chicago", "KL");
			G.addEdge("Chicago", "Mumbai");
			G.addEdge("KL", "Venice");
			G.addEdge("KL", "Athens");
			G.addEdge("Perth", "Atlanta");
			G.addEdge("Perth", "Venice");
			G.addEdge("Perth", "Barcelona");	
			G.addEdge("Atlanta", "Irvine");
			G.addEdge("Atlanta", "Athens");
			G.addEdge("Irvine", "Mumbai");
			G.addEdge("Irvine", "Paris");
			G.addEdge("Irvine", "Athens");
			G.addEdge("Mumbai", "Doha");
			G.addEdge("Paris", "Doha");
			G.addEdge("New York", "Doha");
			G.addEdge("New York", "Amsterdam");
			G.addEdge("Amsterdam", "Barcelona");
			break;		
			
		
		}
	}
}
