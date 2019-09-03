package tut2_question1;

import java.util.Scanner;

public class CircleApp {

	public static void main(String[] args) {
		System.out.println(
				"==== Circle Computation =====\r\n" + 
				"|1. Create a new circle     |\r\n" + 
				"|2. Print Area              |\r\n" + 
				"|3. Print circumference     |\r\n" + 
				"|4. Quit                    |\r\n" + 
				"=============================\r\n"
		);
		
		int n;
		Circle circle = new Circle(0);
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		do {
			System.out.println("Choose option (1-3):");
			n = sc.nextInt();

			switch (n) {
				case 1:
					System.out.println("Enter the radius to compute the area and circumference");
					circle.setRadius(sc2.nextDouble());
					System.out.println("A new circle is created");
					break;
					
				case 2:
					circle.printArea();
					break;
						
				case 3:
					circle.printCircumference();
					break;
					
				default:
					break;
					
			}
		} while (n < 4);
		
		System.out.println("Thank you!!");
		System.exit(0);
	}

}
