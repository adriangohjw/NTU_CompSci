package tut2_question2;
import java.lang.Math;

public class Dice {
	private int valueOfDice;
	
	public Dice() {
		this.valueOfDice = 1;
	}
	
	public void setDiceValue() {
		this.valueOfDice = (int)(Math.random() * ((6 - 1) + 1)) + 1;
	}
	
	public int getDiceValue() {
		return this.valueOfDice;
	}
	
	public void printDiveValue() {
		System.out.println("Current Value is " + this.getDiceValue());
	}
}
