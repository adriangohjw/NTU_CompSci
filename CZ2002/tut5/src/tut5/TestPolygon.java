package tut5;

public class TestPolygon {
	
	// dynamic binding
	public static void printArea(Polygon p) {
		System.out.println(p.calArea());
	}
	
	// static binding
	public static void printArea(Rectangle r) {
		System.out.println(r.calArea());
	}
	
	public static void printArea(Triangle t) {
		System.out.println(t.calArea());
	}
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle("rectangle", 10, 5);
		Triangle t = new Triangle("triangle", 5, 10);
		
		//static binding
		System.out.println("Static binding");
		printArea(r);
		printArea(t);
		
		//dynamic binding
		Polygon p;
		System.out.println("Dynamic binding");
		p = r;
		printArea(p);
		p = t;
		printArea(p);
	}
}
