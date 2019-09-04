package lab1.P3;

import java.util.Scanner;

public class P3 {

	public static void main(String[] args) {
		final double USD_TO_SGD = 1.82;
		
		int starting, ending, increment, i;
		int repeat = 1;
		Scanner sc_starting = new Scanner(System.in);
		Scanner sc_ending = new Scanner(System.in);
		Scanner sc_increment = new Scanner(System.in);
		Scanner sc_repeat = new Scanner(System.in);
		
		do {
			
			System.out.println("Enter starting:");
			starting = sc_starting.nextInt();
			
			System.out.println("Enter ending:");
			ending = sc_ending.nextInt();
			
			System.out.println("Enter increment:");
			increment = sc_increment.nextInt();
			
			if (starting <=  ending) {
				
				// (1) generate table using FOR loop
				System.out.println(
						"Generating table using FOR loop\n" +
						"US$         S$\n" + 
						"--------------\n"
				);
				for (i=starting; i<=ending; i+=increment) {
					System.out.println(i + "         " + (i * USD_TO_SGD));
				}
				System.out.println("\n");
				
				
				// (2) generate table using WHILE loop
				System.out.println(
						"Generating table using WHILE loop\n" +
						"US$         S$\n" + 
						"--------------\n"
				);
				i = starting;
				while (i <= ending) {
					System.out.println(i + "         " + (i * USD_TO_SGD));
					i += increment;
				}
				System.out.println("\n");
				

				// (3) generate table using DO/WHILE loop
				System.out.println(
						"Generating table using DO/WHILE loop\n" +
						"US$         S$\n" + 
						"--------------\n"
				);
				i = starting;
				do {
					System.out.println(i + "         " + (i * USD_TO_SGD));
					i += increment;
				} while (i <= ending);
				System.out.println("\n");
				
			} else {
				
				System.out.println("Error input!");
				
			}
			
			// ask user if they want to repeat
			System.out.println("Repeat question? (Press 1 to repeat)");
			repeat = sc_repeat.nextInt();
			
		} while (repeat == 1);
		
		System.out.println("End of program, bye!");
		System.exit(0);
		
	}

}
