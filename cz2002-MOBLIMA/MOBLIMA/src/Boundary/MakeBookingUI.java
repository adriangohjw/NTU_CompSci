package Boundary;

import Controller.*;
import Model.*;

import java.time.LocalDateTime;
import java.util.*;

public class MakeBookingUI {
	/** 
     * Necessary variables to make a booking (movie title, cinema code, viewing date and time
     */
    private String movieTitle;
    private String cinemaCode;
    private LocalDateTime viewingDateTime;
    
    /** 
     * Variables to store the selected cinema, session and seating plan
     */
    private Cinema queriedCinema;
    private Session queriedSession;
    private SeatingPlan seatAvailability;
    
    /** 
     * Variables to store the number of tickets
     */
    private int amountOfTickets;

    /** 
     * All controllers (cineplex, cinema, movie, session, price, transaction)
     */
    private CineplexesController cineplexesCtrl;
    private CinemasController cinemaCtrl;
    private MoviesController movieCtrl;
    private SessionsController sessCtrl;
    private PriceController priceCtrl;
    private TransactionsController transCtrl;
    /** 
     * Default constructors to call all controllers
     */
    public MakeBookingUI() {
        this.cineplexesCtrl = new CineplexesController();
        this.cinemaCtrl = new CinemasController();
        this.movieCtrl = new MoviesController();
        this.transCtrl = new TransactionsController();
        this.priceCtrl = new PriceController();
        this.sessCtrl = new SessionsController();
        this.cineplexesCtrl = new CineplexesController();
    }
    
    /** 
     * Set the cinema controller to a specific state
     * @param cinemaCtrl The state for the cinema controller
     */
    public void setCinemaCtrl (CinemasController cinemaCtrl) {
    	this.cinemaCtrl = cinemaCtrl;
    }
    
    /** 
     * Set the movie controller to a specific state
     * @param movieCtrl The state for the movie controller
     */
    public void setMovieCtrl (MoviesController movieCtrl) {
    	this.movieCtrl = movieCtrl;
    }
    
    /** 
     * Set the transaction controller to a specific state
     * @param transCtrl The state for the transaction controller
     */
    public void setTransCtrl (TransactionsController transCtrl) {
    	this.transCtrl = transCtrl;
    }
    
    /** 
     * Set the session controller to a specific state
     * @param sessCtrl The state for the session controller
     */
    public void setSessCtrl (SessionsController sessCtrl) {
    	this.sessCtrl = sessCtrl;
    }
    
    /** 
     * Main method for the UI - display all available movies and ask them to pick the cineplex to view
     * If no cinema are available to show the movie for a cineplex, user will be asked to repick the cineplex
     * Then, pass to the other methods to pick date, time and showcase ticket price
     */
    public void main() {
    	ArrayList<Cinema> cinemaList = new ArrayList<Cinema>();
    	int choice;
    	
        System.out.println("Here are the available movies: "); 
        showAvailableMovies();
        
        System.out.println("Choose cineplex (0 to return): ");
        System.out.println();
        
        ArrayList<Cineplex> cineplexes = cineplexesCtrl.read();
        for(int i = 0; i < cineplexes.size(); i++) {
        	System.out.println((i+1) + ". " + cineplexes.get(i).getName());
		}
        
        while (cinemaList.size() == 0) {
        	choice = InputController.getIntFromUser();
        	if (choice == 0) {
        		System.out.println("Returning..."); 
        		return;
        	}
        	else if (choice < 0 || choice > cineplexes.size())
        		System.out.println("Invalid input! Please try again.");
        	else {
        		cinemaList = showAvailableSessions(cineplexes.get(choice-1).getName());
        		if (cinemaList.size() == 0) 
        			System.out.println("No available sessions for this cineplex! Please choose another.");
        	}
        }
        pickDateTimeCode(cinemaList);

		priceShowcase();

    }
    
    /** 
     * Show all available movies (with now showing or preview state)
     */
    public void showAvailableMovies() {
		System.out.println();
    	ArrayList<Movie> movieList = movieCtrl.read();
    	for (int i = 0; i < movieList.size(); i++) {
    		if (movieList.get(i).getShowStatus() == MovieStatus.NOW_SHOWING || movieList.get(i).getShowStatus() == MovieStatus.PREVIEW) {
    			System.out.println(movieList.get(i).getTitle());
    		}
    	}
    	System.out.println();
    }
    
    /** 
     * Show all available sessions for a cineplex knowing the movie
     * @param cineplexName		Name of chosen cineplex
     * @return a list of cinema that can show the movie for that cineplex
     */
    public ArrayList<Cinema> showAvailableSessions(String cineplexName) {
    	Session tempSession;
    	Cinema tempCinema;
    	boolean printedCinemaCode =  false;
    	boolean printSeparator = false;
    	ArrayList<Cinema> tempCinemaList = new ArrayList<Cinema>();
    	System.out.println();
    	System.out.println("Enter movie title to view available sessions: ");
    	movieTitle = InputController.getStringFromUser();
    	ArrayList<Cinema> cinemaList = cinemaCtrl.readByCineplexName(cineplexName);
		System.out.println("------------------------------------------------------");
		for (int i = 0; i < cinemaList.size(); i++) {
    		printedCinemaCode = false;
    		tempCinema = cinemaList.get(i);
    		for(int j = 0; j < tempCinema.getSessions().size(); j++) {
    			tempSession = tempCinema.getSessions().get(j);
    			if (tempSession.getMovie().getTitle().equals(movieTitle)) {
    				if (!printedCinemaCode) {
    					System.out.println("Cinema code: " + tempCinema.getCode() + "		Cinema type: " + tempCinema.getCinemaType());
    					System.out.println();
    					System.out.println("Available screening times of " + movieTitle+ " in this cinema:");
    					System.out.println();
    				}
    				printedCinemaCode = true;
    				System.out.println("	Date: " + tempSession.getSessionDateTimeToString());
    				System.out.println();
    				tempCinemaList.add(tempCinema);
    				printSeparator = true;
    			}
    		}
    		if(printSeparator){
    			System.out.println("------------------------------------------------------");
    			printSeparator = false;
			}
    	}
    	return tempCinemaList;
    }
    
    /** 
     * Allow user to pick date and time for their viewing session
     * @param mainCinemaList		List of chosen cinemas
     */
    public void pickDateTimeCode(ArrayList<Cinema> mainCinemaList) {
    	Session tempSession;
    	Cinema tempCinema;
    	System.out.println("Choose your cinema code: ");
    	cinemaCode = InputController.getStringFromUser();
    	System.out.println("Choose your viewing date and time (in format DD/MM/YYYY HH:MM): ");
    	viewingDateTime = InputController.getDateTimeFromUser();
    	for (int i = 0; i < mainCinemaList.size(); i++) {
    		tempCinema = mainCinemaList.get(i);
    		if (tempCinema.getCode().equals(cinemaCode)) {
    			for(int j = 0; j < tempCinema.getSessions().size(); j++) {
    				tempSession = tempCinema.getSessions().get(j);
    				if (tempSession.getSessionDateTime().equals(viewingDateTime)) {
    					seatAvailability = tempSession.getSeatsAvailability();
    					queriedSession = tempSession;
    					queriedCinema = tempCinema;
    					break; //only one session for that date time
    				}
    			}
    		}
    	}
	}
    
    /** 
     * Allow user to reserve seats knowing the seating plan
     */
    public void reserveSeat() {
    	int id;
    	int amountLeft = amountOfTickets;
    	int counter = 1;
    	boolean seatReserved = false;
    	seatAvailability.printLayout();
    	do{
			System.out.println("Choose seat id for " + counter + " ticket: ");
			id = InputController.getIntFromUser(); //from 0 to row * column - 1
			seatReserved = sessCtrl.assignSeat(seatAvailability, id, queriedSession.getId());
			if(seatReserved){
				amountLeft--;
				counter++;
			}
		}while(amountLeft>0);
		makeTransaction();
	}
    
    /** 
     * Showcasing the price of the tickets
     * Pass to method reserveSeat if the user want to reserve seats
     */
    public void priceShowcase() {
    	double price = 0;
    	System.out.print("Enter the amount of tickets: ");
    	amountOfTickets = InputController.getPositiveIntFromUser();
    	for(int i = 0;i<amountOfTickets;i++){
			boolean validInput = false;
			while(!validInput){
				System.out.println("Enter age type for " + (i+1) + " ticket (Student, Senior, Standard): ");
				String priceTypeString = InputController.getStringFromUser();
				if (priceTypeString.equals("Student")){
					price += priceCtrl.computePrice(queriedSession, queriedCinema, PriceType.STUDENT);
					validInput = true;
				}
				else if (priceTypeString.equals("Senior")){
					price += priceCtrl.computePrice(queriedSession, queriedCinema, PriceType.SENIOR_CITIZEN);
					validInput = true;
				}
				else if(priceTypeString.equals("Standard")){
					price += priceCtrl.computePrice(queriedSession, queriedCinema, PriceType.NORMAL);
					validInput = true;
				}
				else{
					System.out.println("Wrong input!");
				}
			}
		}

    	System.out.println("Total price is equal: " + price + " SGD");
    	System.out.print("Do you want to continue? Yes (0)/ No (1): ");
    	int choice = InputController.getYesOrNoFromUser();
    	if(choice == 0){
    		reserveSeat();
		}
    	else{
    		System.out.println("\nReturning to main menu...\n");
    		return;
		}
    }
    
    /** 
     * Make the transaction with user's info
     */
    public void makeTransaction() {
    	System.out.print("Enter your name: ");
    	String name = InputController.getStringFromUser();
    	System.out.print("Enter your email: ");
    	String email = InputController.getEmailFromUser();
    	System.out.print("Enter your mobile number: ");
    	String mobileNumber = InputController.getMobileNumberFromUser();
    	Movie movie = queriedSession.getMovie();
    	transCtrl.create(cinemaCode, name, email, mobileNumber, movie);
    	System.out.println("Transaction successful!");
    }
}
