package Boundary;

import java.time.LocalDate;
import java.util.ArrayList;

import Controller.*;
import Model.*;

public class ConfigureSystemSetting {
	/** 
     * All controllers - holCtrl, priceCtrl
     */
	private HolidaysController holCtrl = new HolidaysController();
	private PriceController priceCtrl = new PriceController();
	
	/** 
     * Main method to load - display all available options and ask user to choose one
     */
	public void main() {
		boolean exit  = false;
		int choice;
		while (!exit){
			System.out.println("\nConfigure System Settings: \n" +
					"1.  Add Holiday \n" +
					"2.  Delete Holiday \n" +
					"3.  List all holidays \n" +
					"4.  Update Movie Type Price \n" +
					"5.  Update Cinema Type Price \n" +
					"6.  Update Student Price \n" +
					"7.  Update Senior Citizen Price \n" +
					"8.  Update Standard Price \n" +
					"9.  Update Weekend Price \n" +
					"10. Update Holiday Price \n" +
					"11. Return to Main Menu");
			choice = InputController.getIntFromUser();
			switch (choice) {
				case 1:
					createHoliday();
					break;
				case 2:
					deleteHoliday();
					break;
				case 3:
					listAllHolidays();
					break;
				case 4:
					updateMovieTypePrice();
					break;
				case 5:
					updateCinemaTypePrice();
					break;
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
					updatePriceType(choice);
					break;
				case 11:
					exit = true;
					break;
				default:
					System.out.println("Wrong input!");
					break;
			}
		}

	}
	
	/** 
     * Create a new holiday - ask user to enter date
     * If the holiday already exists, the user has to try again
     */
	public void createHoliday() {
		System.out.println("Enter holiday date: ");
		LocalDate holiday = InputController.getDateFromUser();
		if (holCtrl.isHoliday(holiday)) {
			System.out.println("Holiday already exists!\n");
			return;
		}
		holCtrl.create(holiday);
	}

	/** 
     * List all available holidays (If there are any)
     * @return		If there are available holidays or not
     */
	public boolean listAllHolidays(){
		ArrayList<Holiday> holList = holCtrl.read();
		if(holList.isEmpty()){
			System.out.println("\nThere are no holidays declared!");
			return false;
		}
		else{
			System.out.println("\nCurrently declared holidays: \n");
			holList.forEach(Holiday -> printHol(Holiday));
		}
		System.out.println();
		return true;
	}
	
	/** 
     * Delete a holiday from database
     * If the user's input is invalid, they have to try again
     */
	public void deleteHoliday() {
		if(listAllHolidays()){
			System.out.println("Enter holiday date to delete: ");
			LocalDate holiday = InputController.getDateFromUser();
			if (!holCtrl.isHoliday(holiday)) {
				System.out.println("Holiday does not exist!\n");
				return;
			}
			holCtrl.delete(holiday);
		}
	}
	
	/** 
     * Update the price of a specific movie type (user's choosing)
     * Invalid choice will return the user back to main menu
     */
	public void updateMovieTypePrice() {
		System.out.println("Choose Movie Type: \n" +
						   "1. 2D\n" +
						   "2. 3D\n" +
						   "3. Blockbuster\n" +
						   "Option: ");
		int choice = InputController.getIntFromUser();
		System.out.println("Enter new price: ");
		double newPrice = InputController.getDoubleFromUser();
		switch(choice) {
			case 1:
				priceCtrl.changePriceChanger(MovieType.TWO_D, newPrice);
				break;
			case 2:
				priceCtrl.changePriceChanger(MovieType.THREE_D, newPrice);
				break;
			case 3:
				priceCtrl.changePriceChanger(MovieType.BLOCKBUSTER, newPrice);
				break;
			default:
				System.out.println("invalid choice!\n" +
								   "Returning to menu...");
		}
	}
	
	/** 
     * Update the price of a specific cinema type (user's choosing)
     * Invalid choice will return the user back to main menu
     */
	public void updateCinemaTypePrice() {
		System.out.println("Choose Cinema Type: \n" +
						   "1. Standard\n" +
						   "2. Premium\n" +
						   "Option: ");
		int choice = InputController.getIntFromUser();
		System.out.println("Enter new price: ");
		double newPrice = InputController.getDoubleFromUser();
		switch(choice) {
			case 1:
				priceCtrl.changePriceChanger(CinemaType.STANDARD, newPrice);
				break;
			case 2:
				priceCtrl.changePriceChanger(CinemaType.PREMIUM, newPrice);
				break;
			default:
				System.out.println("invalid choice!\n" +
								   "Returning to menu...");
		}
	}
	
	/** 
     * Update the price of a specific ticket type (user's choosing)
	 * @param choice 	Execute different price change based on user's input
     */
	public void updatePriceType(int choice) {
		System.out.println("Enter new price: ");
		double newPrice = InputController.getDoubleFromUser();
		switch(choice) {
		case 5:
			priceCtrl.changePriceChanger(PriceType.STUDENT, newPrice);
			break;
		case 6:
			priceCtrl.changePriceChanger(PriceType.SENIOR_CITIZEN, newPrice);
			break;
		case 7:
			priceCtrl.changePriceChanger(PriceType.NORMAL, newPrice);
			break;
		case 8:
			priceCtrl.changePriceChanger(PriceType.WEEKEND, newPrice);
			break;
		case 9:
			priceCtrl.changePriceChanger(PriceType.HOLIDAY, newPrice);
			break;
		}
	}
	
	/** 
     * Print a holiday's date
	 * @param holiday 	The date of holiday to be printed
     */
	public void printHol(Holiday holiday) {
		System.out.println(holiday.getHolidayDateToString());
	}
}
