package tut3_question2;

public class Cylinder extends Circle {
	
	protected int height;
	protected double volume;

	public Cylinder(int x, int y) {
		super(x, y);
		this.volume();
	}
	
	public void setHeight(int h) {
		this.height = h;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public String toString() {
		return super.toString();
	}
	
	public void area() {
		super.area();
	}
	
	public void volume() {
		this.volume = super.area * this.height;
	}
	
}
