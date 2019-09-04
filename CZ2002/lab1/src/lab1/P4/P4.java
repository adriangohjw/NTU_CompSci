package lab1.P4;

import java.util.Scanner;

public class P4 {

	public static void main(String[] args) {

		int repeat = 1;
		int height, i, j;
		Scanner sc_height = new Scanner(System.in);
		Scanner sc_repeat = new Scanner(System.in);
		
		do {

			System.out.println("Enter height:");
			height = sc_height.nextInt();
			
			if (height > 0) {
				
				// branch out based on line#
				for(i=0; i<height; i++) {
					
					if (i % 2 == 0) {  // if line# is odd
						for (j=0; j<=i; j++) {
							if (j % 2 == 0) {
								System.out.printf("AA");
							} else {
								System.out.printf("BB");
							}
						}
					} else { // if line# is even
						for (j=0; j<=i; j++) {
							if (j % 2 == 0) {
								System.out.printf("BB");
							} else {
								System.out.printf("AA");
							}
						}
					}
			
					System.out.println();
				}
				
			} else {
				
				System.out.println("Error input!");
				
			}
			
			System.out.println("Repeat question? (Press 1 to repeat)");
			repeat = sc_repeat.nextInt();
			
		} while (repeat == 1);

		System.out.println("End of program, bye!");
		System.exit(0);
		
	}

}
