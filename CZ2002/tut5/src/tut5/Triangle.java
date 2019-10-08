package tut5;

public class Triangle extends Polygon {
	
	public Triangle(String theName, float theWidth, float theHeight) {
		super(theName, theHeight, theHeight);
		this.polytype = KindofPolygon.POLY_TRIANG;
	}
	
	public float calArea() {
		return (float) 0.5 * super.width * super.height;
	}
}