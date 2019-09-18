package lab2;

import java.util.Scanner;
import java.math.*;

public class Lab2p1 {
	public static void main(String[] args) {
		int choice;
		Scanner sc = new Scanner(System.in);
		int var1, var2, result;
		long var1Long, resultLong;
		Scanner input1 = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		do {
			System.out.println("Perform the following methods:");
			System.out.println("1: miltiplication test");
			System.out.println("2: quotient using division by subtraction");
			System.out.println("3: remainder using division by subtraction");
			System.out.println("4: count the number of digits");
			System.out.println("5: position of a digit");
			System.out.println("6: extract all odd digits");
			System.out.println("7: quit");
			choice = sc.nextInt();
			switch (choice) {
				case 1: 
					mulTest();
					break;
					
				case 2: 
					System.out.println("Enter value of m:");
					var1 = input1.nextInt();
					System.out.println("Enter value of n:");
					var2 = input1.nextInt();
					System.out.println(var1 + "/" + var2 + " = " + (divide(var1, var2)));
					break;
					
				case 3: 
					System.out.println("Enter value of m:");
					var1 = input1.nextInt();
					System.out.println("Enter value of n:");
					var2 = input1.nextInt();
					System.out.println(var1 + " % " + var2 + " = " + (modulus(var1, var2)));
					break;
					
				case 4: 
					System.out.println("Enter value of n:");
					var1 = input1.nextInt();
					result = countDigits(var1);
					
					if (result >= 1) {
						System.out.println("n : " + var1 + " - count = " + result);
					} else {
						System.out.println("n : " + var1 + " - Error input!!");
					}
					
					break;
					
				case 5: 
					System.out.println("Enter value of n:");
					var1 = input1.nextInt();
					System.out.println("Enter value of digit:");
					var2 = input1.nextInt();
					System.out.println("position = " + position(var1, var2));
					break;
					
				case 6: 
					System.out.println("Enter value of n:");
					var1Long = input1.nextLong();
					resultLong = extractOddDigits(var1Long);
	
					if (resultLong == -2) {
						System.out.println("oddDigits = Error input!!");
					} else {
						System.out.println("oddDigits  = " + resultLong);
					}
					
					break; 
					
				case 7: 
					System.out.println("Program terminating ….");
					break;
					
			}
		} while (choice < 7);
		
	}
	
	private static void mulTest() {
		
		int score = 0;
		int randomNum1, randomNum2;
		Scanner userInput = new Scanner(System.in);
		for (int i=0; i<5; i++) {
			randomNum1 = (int) (1 + (Math.random() * 9));
			randomNum2 = (int) (1 + (Math.random() * 9));
			System.out.println("How much is " + randomNum1 + " times " + randomNum2 + "?");
			if (userInput.nextInt() == (randomNum1 * randomNum2)) {
				score++;
			}
		}
		System.out.println(score + " answers out of 5 are correct.");
	}
	
	public static int divide(int m, int n) {
		
		if (m < n) {
			return 0;
		} else {
			return divide(m-n, n) + 1;
		}
	}
	
	public static int modulus(int m, int n) {
		
		if (m < n) {
			return m;
		} else {
			return modulus(m-n, n);
		}
	
	}
	
	public static int countDigits(int n) {
		
		if (n <= 0) {
			return 0;
		} else {
			return countDigits(n/10) + 1;
		}
		
	}
	
	public static int position(int n, int digit) {
		
		int nLength = countDigits(n);
		int pos = 0;
		
		for(int i=0; i<nLength; i++) {
			pos++;
			if (n % 10 == digit) {
				break;
			} 
			n /= 10;
		}
		
		return (pos == nLength) ? -1 : pos;
		
	}
	
	public static long extractOddDigits(long n) {
		
		long result = 0;
		int counter = 0;
		
		if (n < 0) {
			return -2;
		}
		
		while (n > 0) {
			if (n % 2 == 1) {
				result += ((n % 10) * Math.pow(10, counter));
				counter++;
			}
			n /= 10;
		}
		
		return (result != 0) ? result : -1;
		
	}
	
}