package Boundary;

import Controller.InputController;
import Controller.MoviesController;
import Controller.ReviewsController;
import Model.Movie;

import java.util.ArrayList;

public class RateMovieUI {
	/** 
     * All controllers (movie, review) and SearchMovieUI() method
     */
    private MoviesController moviesController = new MoviesController();
    private ReviewsController reviewsController = new ReviewsController();
    private SearchMovieUI searchMovieUI = new SearchMovieUI();

    /** 
     * Main method to display - pass the controller to search movie UI for user to pick a movie to review
     */
    public void display(){
        System.out.println("Input your username: ");
        String username = InputController.getStringFromUser();
        if(searchMovieUI.listAllMovies()){
            System.out.print("Select the title of movie which you want to rate: ");
            String title = InputController.getStringFromUser();
            ArrayList<Movie> movie = moviesController.readByAttribute(MoviesController.TITLE, title);
            if(movie.isEmpty()){
                System.out.println("\nMovie with this title doesn't exist!");
                System.out.println("Returning to menu...\n");
                return;
            }
            System.out.println("Input number of stars (0-5):");
            double stars = InputController.getDoubleFromUser(5);
            System.out.println("Input additional comment");
            String comment = InputController.getStringFromUser();
            reviewsController.create(movie.get(0), username, stars, comment);
        }
    }
}
