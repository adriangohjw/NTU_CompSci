package Boundary;

import Controller.*;
import Model.*;

import java.util.*;

public class ListTopMovieUI {
	/** 
     * User's choice and the movie controller
     */
	private int choice;
	private MoviesController moviesCtrl;

	/** 
     * Default constructor
     */
	public ListTopMovieUI() {
		this.moviesCtrl = new MoviesController();
	}
	/** 
     * Constructor with a specific controller state
     * @param moviesCtrl	The state to be set for the movie controller
     */
	public ListTopMovieUI(MoviesController moviesCtrl) {
		this.moviesCtrl = moviesCtrl;
	}
	/** 
     * Main method to load - show display while the choice is not to return
     */
	public void main(){
		while (choice != 3)
			display();
	}
	/** 
     * Display all available options and ask user to choose one
     */
	public void display() {
		System.out.println("Select 1 to list top 5 movies according to ratings.");
		System.out.println("Select 2 to list top 5 movies according to ticket sales.");
		System.out.println("Select 3 to go back.");

		choice = InputController.getIntFromUser();
		switch (choice) {
		case 1:
			listWithRatings();
			break;
		case 2:
			listWithSales();
			break;
		case 3:
			System.out.println("Going back...");
			break;
		default:
			System.out.println("Invalid input! Please try again.");
		}
	}
	/** 
     * List top movies, ranked by ratings
     */
	public void listWithRatings(){
		ArrayList<Movie> movieList = moviesCtrl.read();
		Collections.sort(movieList, new SortByRating());
		int amount = 0;
		if(movieList.size()<5){
			amount = movieList.size();
		}
		else{
			amount = 5;
		}
		for (int i = 0; i < amount; i++) {
			printMovie(movieList.get(i));
		}
		ViewMovieDetailUI view = new ViewMovieDetailUI();
		view.main();
	}
	/** 
     * List top movies, ranked by ticket sales
     */
	public void listWithSales(){
		ArrayList<Movie> movieList = moviesCtrl.read();
		Collections.sort(movieList, new SortBySales());
		int amount = 0;
		if(movieList.size()<5){
			amount = movieList.size();
		}
		else{
			amount = 5;
		}
		for (int i = 0; i < amount; i++) {
			printMovie(movieList.get(i));
		}
		ViewMovieDetailUI view = new ViewMovieDetailUI();
		view.main();
	}

	/** 
     * Print a movie's detail
     * @param movie		Movie to be printed
     */
    public void printMovie(Movie movie){
		System.out.println("ID: " + movie.getId());
        System.out.println("Title: " + movie.getTitle());
        System.out.println("Rating: " + movie.getOverallReviews());
        System.out.println("-------------------");
    }
}

class SortByRating implements Comparator<Movie> {

	/** 
     * Implementing the compare method to use in Collections.sort()
     * @param a			Movie 1 to be compared
     * @param b			Movie 1 to be compared
     */
	public int compare(Movie a, Movie b) {
		String ratingA = a.getOverallReviews();
		String ratingB = b.getOverallReviews();
		if(ratingA == "N/A" && ratingB == "N/A") return 0;
		if(ratingA == "N/A") return 1;
		if(ratingB == "N/A") return -1;
		double difference = Double.parseDouble(ratingA) - Double.parseDouble(ratingB);
		if (difference > 0) return -1;
		if (difference < 0) return 1;
		return 0;
	}
}

class SortBySales implements Comparator<Movie> {
	/** 
     * Implementing the compare method to use in Collections.sort()
     * @param a			Movie 1 to be compared
     * @param b			Movie 1 to be compared
     */
	public int compare(Movie a, Movie b) {
		TransactionsController transCtrl = new TransactionsController();
		ArrayList<Transaction> transList = transCtrl.read();
		int salesA = 0, salesB = 0;
		for (int i = 0; i < transList.size(); i++) {
			if (transList.get(i).getMovie().equals(a)) salesA++;
			if (transList.get(i).getMovie().equals(b)) salesB++;
		}
		return salesA - salesB;
	}
}
