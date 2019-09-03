package tut3_question2;

import java.lang.Math;

public class Circle extends Point {

	protected int radius;
	protected double area;
	
	public Circle(int x, int y) {
		super(x, y);
		this.area();
	}

	public void setRadius(int r) {
		this.radius = r;
	}
	
	public int getRadius(int r) {
		return this.radius;
	}
	
	public String toString() {
		return super.toString();
	}
	
	public void area() {
		this.area = Math.PI * this.radius * this.radius;
	}
	
}
