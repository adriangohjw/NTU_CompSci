package tut3_question2;

import java.lang.Math;

public class Circle extends Point {

	protected double radius;
	
	public Circle(int x, int y, double radius) {
		super(x, y);
		this.radius = radius;
		this.area();
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public String toString() {
		return super.toString();
	}
	
	public double area() {
		return Math.PI * Math.pow(this.radius, 2);
	}
	
}
