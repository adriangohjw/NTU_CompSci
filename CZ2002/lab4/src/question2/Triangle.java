package question2;

public class Triangle implements Shape {

	private int height;
	private int base;
	
	public Triangle(int height, int base) {
		this.height = height;
		this.base = base;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public double getArea() {
		return 0.5 * this.height * this.base;
	}
}
