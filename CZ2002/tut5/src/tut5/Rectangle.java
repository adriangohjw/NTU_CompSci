package tut5;

public class Rectangle extends Polygon {
	
	public Rectangle(String theName, float theWidth, float theHeight) {
		super(theName, theHeight, theHeight);
		this.polytype = KindofPolygon.POLY_RECT;
	}
	
	public float calArea() {
		return super.width * super.height;
	}
}