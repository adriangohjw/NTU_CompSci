package question2;

public class Cone extends Circle implements _3d {

	private int height;
	
	public Cone(int radius, int height) {
		super(radius);
		this.height = height;
	}
	
	public double getVolume() {
		return (1.0 / 3.0) * Math.PI * Math.pow(super.getRadius(), 2) * this.height;
	}
	
	public double getSurfaceArea() {
		return Math.PI * super.getRadius() 
				* (super.getRadius() + Math.sqrt(Math.pow(this.height, 2) + Math.pow(super.getRadius(), 2)));
	}
	
}
