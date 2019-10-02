package lab3;

import java.util.Scanner;

public class PlaneApp {

	public static void main(String[] args) {
		
		Plane app = new Plane();
		boolean repeat = true;
		Scanner sc = new Scanner(System.in);
		int userInput1, userInput2;
		
		System.out.println("(1) Show number of empty seats");
		System.out.println("(2) Show the list of empty seats");
		System.out.println("(3) Show the list of seat assignments by seat ID");
		System.out.println("(4) Show the list of seat assignments by customer ID");
		System.out.println("(5) Assign a customer to a seat");
		System.out.println("(6) Remove a seat assignment");
		System.out.println("(7) Exit");
		
		while (repeat) {
			System.out.println("Enter the number of your choice: ");
			switch (sc.nextInt()) {
			
				case 1:
					app.showNumEmptySeats();
					break;
					
				case 2:
					app.showEmptySeats();
					break;
					
				case 3:
					app.showAssignedSeat(true);
					break;
					
				case 4:
					app.showAssignedSeat(false);
					break;
					
				case 5:
					System.out.println("Assigning Seat ..");
					System.out.println("Please enter SeatID: ");
					userInput1 = sc.nextInt();
					System.out.println("Please enter Customer ID:");
					userInput2 = sc.nextInt();
					app.assignSeat(userInput1, userInput2);
					break;
					
				case 6:
					System.out.println("Enter SeatID to unassign customer from: ");
					userInput1 = sc.nextInt();
					app.unAssignSeat(userInput1);
					break;
					
				case 7:
					repeat = false;
					break;
					
				default:
					System.out.println("Invalid command, please try again!");
					
			}
		}
	}

}
