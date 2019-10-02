package tut4_question4;

public class UnknownOperatorException extends Exception {

	public UnknownOperatorException() {
		super("UnknownOperatorException");
	}
	
	public UnknownOperatorException(char op) {
		super(op + " is an unknown operator");
	}
	
	public UnknownOperatorException(String message) {
		super(message);
	}
}
