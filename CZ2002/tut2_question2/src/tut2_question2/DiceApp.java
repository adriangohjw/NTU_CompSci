package tut2_question2;

import java.util.Scanner;

public class DiceApp {

	public static void main(String[] args) {
		
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		System.out.println("Press <key> to roll the first dice");
		sc1.next();
		Dice dice1 = new Dice();
		dice1.setDiceValue();
		dice1.printDiveValue();
		
		System.out.println("Press <key> to roll the second dice");
		sc1.next();
		Dice dice2 = new Dice();
		dice2.setDiceValue();
		dice2.printDiveValue();
		
		System.out.println("Your total number is: " + (dice1.getDiceValue() + dice2.getDiceValue()));
		System.exit(0);
	}

}
