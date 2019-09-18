package tut3_question2;

public class Cylinder extends Circle {
	
	protected double height;

	public Cylinder(int x, int y, double radius, double height) {
		super(x, y, radius);
		this.height = height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public String toString() {
		return super.toString();
	}
	
	public double area() {
		return 2 * (super.area() + (Math.PI * super.getRadius() * this.height));
	}
	
	public double volume() {
		return super.area() * height;
	}
	
}
