package question2;

public class Square extends Rectangle {

	public Square(int side) {
		super(side ,side);		
	}
	
	public int getSide() {
		return super.getLength();
	}
	
	public void setSide(int side) {
		super.setLength(side);
		super.setWidth(side);
	}
}
