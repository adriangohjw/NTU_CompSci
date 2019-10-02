package tut4_question4;

import java.util.Scanner;

public class CalculatorEx {

	private double result;
	
	public CalculatorEx() {
		result = 0;
	}
	
	public double resultValue() {
		return this.result;
	}
	
	public void doCalculation() throws UnknownOperatorException {
		char op;
		double userInput;
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("result = " + this.resultValue()); 
		
		while (true) {
			System.out.println("Enter + - * / or Q/q to quit"); 
			op = sc.next().charAt(0);
			
			if (op=='q' || op=='Q')
				break;
			
			System.out.println("Enter the number > "); 
			userInput = sc.nextDouble();
			
			result = evaluate(op, this.resultValue(), userInput);
			System.out.println("result " + op + " " + userInput + " = " + this.resultValue()); 
			System.out.println("updated result = " + this.resultValue()); 
			
		};
		
	}
	
	public double evaluate(char op, double n1, double n2) throws UnknownOperatorException {
		double answer;
		switch (op) {
			case '+':
				answer = n1 + n2;
				break;
			case '-':
				answer = n1 - n2;
				break;
			case '*':
				answer = n1 * n2;
				break;
			case '/':
				answer = n1 / n2;
				break;
			default:
				throw new UnknownOperatorException(op); 
		}
		return answer;
	}
	
	public void handleUnknownOpException(UnknownOperatorException e) {
		System.out.println(e.getMessage()); 
		System.out.println("Please reenter:"); 
		try {
			doCalculation();
		} 
		catch (Exception e2) {
			System.out.println(e2.getMessage()); 
		}
	}
	
	public static void main(String[] args) {
		
		CalculatorEx app = new CalculatorEx();
		
		try {
			System.out.println("Calculator is on");
			app.doCalculation();
		} 
		catch (UnknownOperatorException e) {	
			app.handleUnknownOpException(e);
		} 
		catch (Exception e) {
			System.out.println("Other Exception " + e.getMessage()); 
		}
		
		System.out.println("Final result = " + app.resultValue());
		System.out.println("End of program"); 
		System.exit(0);
	}

}
