package question2;

public class Cylinder extends Circle implements _3d {

	private int height;
	
	public Cylinder(int radius, int height) {
		super(radius);
		this.height = height;
	}
	
	public double getVolume() {
		return Math.PI * Math.pow(super.getRadius(), 2) * this.height;
	}
	
	public double getSurfaceArea() {
		return (2 * Math.PI * super.getRadius() * this.height)
				+ (2 * Math.PI * Math.pow(super.getRadius(), 2));
	}
}
