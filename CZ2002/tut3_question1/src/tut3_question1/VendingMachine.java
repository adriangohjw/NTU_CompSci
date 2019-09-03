package tut3_question1;

import java.util.Scanner;

public class VendingMachine {
	
	// constructor
	public VendingMachine() {
		double drinkCost = this.selectDrink();
		this.checkChange(this.insertCoins(drinkCost), drinkCost);
		this.printReceipt();
	}
	
	// get the drink selection, and return the cost of the drink
	public double selectDrink() {
		Scanner sc = new Scanner(System.in);
		double drinkCost;
		
		System.out.println(
				"====== Vending Machine ======\n" + 
				"|1. Buy Beer ($3.00)        |\n" + 
				"|2. Buy Coke ($1.00)        |\n" + 
				"|3. Buy Green Tea ($5.00)   |\n" + 
				"|============================\n" +
				"Please enter selection: "
		);
		
		switch (sc.nextInt()) {
			case 1:
				drinkCost = 3.00;
				break;
			case 2: 
				drinkCost = 1.00;
				break;
			case 3: 
				drinkCost = 5.00;
				break;
			default: 
				drinkCost = 0.0;
				break;
		}
		
		return drinkCost;
	}
	
	// insert the coins and returns the amount inserted
	public double insertCoins(double drinkCost) {
		
		double amount = 0.0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println(
				"Please insert coins:\n" + 
				"========== Coins Input ===========\n" + 
				"|Enter 'Q' for ten cents input   |\n" + 
				"|Enter 'T' for twenty cents input|\n" +
				"|Enter 'F' for fifty cents input |\n" + 
				"|Enter 'N' for a dollar input    |\n" + 
				"=================================="
		);
		
		while (drinkCost - amount > 0) {
			switch (sc.next()) {
				case "Q":
					amount += 0.10;
					break;
				case "T":
					amount += 0.20;
					break;
				case "F":
					amount += 0.50;
					break;
				case "N":
					amount += 1.00;
					break;
				default:
					break;
			}
			System.out.println("Coins inserted: " + amount);
		}
		
		return amount;
	}
	
	// check the change and print the change on screen
	public void checkChange(double amount, double drinkCost) {
		System.out.println("Change: $ " + (amount - drinkCost));
	}
	
	// print the receipt and collect the drink
	public void printReceipt(){
		System.out.println(
				"Please collect your drink\n" + 
				"Thank You !!"
		);
	}
}
