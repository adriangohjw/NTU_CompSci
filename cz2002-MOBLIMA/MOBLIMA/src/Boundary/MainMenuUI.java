package Boundary;

import Controller.CineplexesController;
import Controller.InputController;
import Model.Cinema;
import Model.CinemaType;
import Model.SeatingPlan;

import java.util.ArrayList;

public class MainMenuUI {
	
	/** 
     * Main method to display while loading the app
     */
	public static void main(String[] args) {
		initializeSystem();

		boolean exit = false;
		while (!exit) {
			System.out.println("|======================================|");
			System.out.println("|=========|Welcome to MOBLIMA|=========|");
			System.out.println("|======================================|\n" +
					"\n\n" +
					"1. Admin\n" +
					"2. Movie Goer\n" +
					"3. New admin account\n" +
					"4. Exit\n");
			System.out.print("Select action: ");
		switch(InputController.getIntFromUser()) {
			case 1:
				admin_login();
				break;
			case 2:
				movie_goer();
				break;
			case 3: 
				register();
				break;
			case 4:
				exit = true;
				System.out.println("Exiting MOBLIMA");
				break;
			default:
				System.out.println("Wrong input!");
			}
			
		}
	}

	/** 
     * Initializing the system (adding cinemas and cineplexes)
     */
	private static void initializeSystem() {
		CineplexesController cineplexesController = new CineplexesController();

		ArrayList<Cinema> cinemasOne = new ArrayList<>();
		ArrayList<Cinema> cinemasTwo = new ArrayList<>();

		cinemasOne.add(new Cinema("GHK",CinemaType.PREMIUM,new SeatingPlan(10,10)));
		cinemasOne.add(new Cinema("DFK",CinemaType.PREMIUM,new SeatingPlan(10,10)));
		cinemasOne.add(new Cinema("TYU",CinemaType.STANDARD,new SeatingPlan(10,10)));
		cinemasTwo.add(new Cinema("XDP",CinemaType.PREMIUM,new SeatingPlan(10,10)));
		cinemasTwo.add(new Cinema("PUP",CinemaType.PREMIUM,new SeatingPlan(10,10)));
		cinemasTwo.add(new Cinema("VAL",CinemaType.STANDARD,new SeatingPlan(10,10)));

		if(cineplexesController.read().size()==0){
			System.out.println(cinemasOne.size());
			cineplexesController.create("First", cinemasOne);
			cineplexesController.create("Second", cinemasTwo);
		}
	}

	/** 
     * Main method to display after logging in as an admin - ask user to pick one of the options
     */
	public static void admin_login(){
		LoginUI admin_login = new LoginUI(1);
		boolean loggedIn = admin_login.main();
		while (loggedIn) {
			System.out.println("|=========================================|");
			System.out.println("|=========|MOBLIMA Administrator|=========|");
			System.out.println("|=========================================|\n" +
						"\n\n"+
					   "1. Create/Update/Remove movie listing\n"+
					   "2. Create/Update/Remove movie session\n"+
					   "3. Configure system settings\n" +
					   "4. Search/List movies\n" +
					   "5. View move details\n" +
					   "6. Log out\n");
			System.out.print("Select action: ");
			switch(InputController.getIntFromUser()) {
				case 1:
					CUR_Movie_Listing curMovieListing = new CUR_Movie_Listing();
					curMovieListing.main();
					break;
				case 2:
					CUR_Sessions curSessions = new CUR_Sessions();
					curSessions.main();
					break;
				case 3:
					ConfigureSystemSetting conf = new ConfigureSystemSetting();
					conf.main();
					break;
				case 4:
					SearchMovieUI searchMovieUI = new SearchMovieUI();
					searchMovieUI.main();
					break;
				case 5:
					ViewMovieDetailUI viewMovieDetailUI = new ViewMovieDetailUI();
					viewMovieDetailUI.main();
					break;
				case 6:
					loggedIn = false;
					System.out.println("Logged out successfully!");
					System.out.println();
					System.out.println();
					break;
				default:
					System.out.println("Try again!");
					break;
			}
		}
	}
	
	/** 
     * Main method to display after logging in as a movie goer - ask user to pick one of the options
     */
	public static void movie_goer() {
		boolean exit = false;
		while (!exit) {
			System.out.println("\n|=========================================|");
			System.out.println("|================|MOBLIMA|================|");
			System.out.println("|=========================================|");
			System.out.print("\n"+
					   "1. Search/List movie\n"+
					   "2. View movie details\n"+
					   "3. Check seat availibility\n" +
					   "4. Book ticket\n" +
					   "5. View booking history\n" +
					   "6. List Top 5 movies\n" +
					   "7. Rate Movie\n" +
					   "8. Exit\n" +
					   "\nSelect action: ");
			switch(InputController.getIntFromUser()) {
				case 1:
					SearchMovieUI searchMovieUI = new SearchMovieUI();
					searchMovieUI.main();
					break;
				case 2:
					ViewMovieDetailUI viewMovieDetailUI = new ViewMovieDetailUI();
					viewMovieDetailUI.main();
					break;
				case 3:
					CheckSeatUI checkSeatUI = new CheckSeatUI();
					checkSeatUI.main();
					break;
				case 4:
					MakeBookingUI makeBookingUI = new MakeBookingUI();
					makeBookingUI.main();
					break;
				case 5:
					ViewBookingUI viewBookingUI = new ViewBookingUI();
					viewBookingUI.main();
					break;
				case 6:
					ListTopMovieUI listTopMovieUI = new ListTopMovieUI();
					listTopMovieUI.main();
					break;
				case 7:
					RateMovieUI rateMovieUI = new RateMovieUI();
					rateMovieUI.display();
					break;
				case 8:
					System.out.println("Exiting...");
					exit = true;
					break;
				default:
					System.out.println("Try again!");
					break;
			}
					
		}

	}
	
	/** 
     * Loading up the register UI if the user is new
     */
	public static void register(){
		RegisterUI registerUI = new RegisterUI();
		registerUI.main();
		
	}
}
