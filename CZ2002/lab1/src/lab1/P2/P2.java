package lab1.P2;

import java.util.Scanner;

public class P2 {
	
	private static Object grade;
	private static Object String;

	public static void main(String[] args) {
		
		int repeat = 1;
		int salary, merit;
		Scanner sc_salary = new Scanner(System.in);
		Scanner sc_merit = new Scanner(System.in);
		Scanner sc_repeat = new Scanner(System.in);
		
		do {

			String grade = null;
			
			System.out.println("Enter salary:");
			salary = sc_salary.nextInt();
			
			System.out.println("Enter merit poitns:");
			merit = sc_merit.nextInt();
			
			if (salary < 600) {
				grade = "C";
			} else if ((salary >= 600) && (salary <= 649)) {
				grade = (merit < 10) ? "C" : "B";
			} else if (salary < 700) {
				grade = "B";
			} else if ((salary >= 700) && (salary <= 799)) {
				grade = (merit < 20) ? "B" : "A";
			} else {
				grade = "A";
			}
			
			System.out.println("The grade is " + grade);
			
			System.out.println("Repeat question? (Press 1 to repeat)");
			repeat = sc_repeat.nextInt();
			
		} while (repeat == 1);

		System.out.println("End of program, bye!");
		System.exit(0);
	}
}
