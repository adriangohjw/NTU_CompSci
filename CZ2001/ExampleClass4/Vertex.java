
public class Vertex {
	private String city;
	private boolean visited;
    Vertex(String city) {
        this.city = city;
        this.visited = false;
    }
    
    public String getCity() {
    	return this.city;
    }
    
    public boolean getVisited() {
    	return this.visited;
    }
    
    public void setAsVisited() {
    	this.visited = true;
    }
    
}
