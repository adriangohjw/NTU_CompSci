package tut3_question1_improved;

import java.util.Scanner;

public class VendingMachine {
	
	private double drinkCost;
	private double amount;
	
	public VendingMachine() {
		this.drinkCost = 0;
		this.amount = 0;
		this.selectDrink();
		this.insertCoins();
		this.checkChange();
		this.printReceipt();
	}
	
	// get the drink selection, and set the cost of the drink (drinkCost)
	public void selectDrink() {
		Scanner sc = new Scanner(System.in);
		
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
				this.drinkCost = 3.00;
				break;
			case 2: 
				this.drinkCost = 1.00;
				break;
			case 3: 
				this.drinkCost = 5.00;
				break;
			default: 
				this.drinkCost = 0.0;
				break;
		}
		
	}
	
	// insert the coins and update the total amount inserted (amount)
	public void insertCoins() {
		
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
		
		while (this.drinkCost - this.amount > 0) {
			switch (sc.next()) {
				case "Q":
					this.amount += 0.10;
					break;
				case "T":
					this.amount += 0.20;
					break;
				case "F":
					this.amount += 0.50;
					break;
				case "N":
					this.amount += 1.00;
					break;
				default:
					break;
			}
			System.out.println("Coins inserted: " + this.amount);
		}
		
	}
	
	// check the change and print the change on screen
	public void checkChange() {
		System.out.println("Change: $ " + (this.amount - this.drinkCost));
	}
	
	// print the receipt and collect the drink
	public void printReceipt(){
		System.out.println(
				"Please collect your drink\n" + 
				"Thank You !!"
		);
	}
}
