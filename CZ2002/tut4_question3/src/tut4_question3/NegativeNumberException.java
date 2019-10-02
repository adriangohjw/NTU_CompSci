package tut4_question3;

public class NegativeNumberException extends Exception {
	
	public NegativeNumberException() {
		super("Negative Number Exception!");
	}
	
	public NegativeNumberException(String message) {
		super(message);
	}
}
