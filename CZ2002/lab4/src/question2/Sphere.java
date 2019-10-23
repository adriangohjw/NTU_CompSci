package question2;

public class Sphere extends Circle implements _3d{

	public Sphere(int radius) {
		super(radius);
	}
	
	public double getVolume() {
		System.out.println(super.getRadius());
		System.out.println(Math.pow(super.getRadius(), 3));
		return (4.0 / 3.0) * Math.PI * Math.pow(super.getRadius(), 3);
	}

	@Override
	public double getSurfaceArea() {
		// TODO Auto-generated method stub
		return 0;
	}
}
