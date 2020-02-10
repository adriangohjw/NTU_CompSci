package Boundary;

import Controller.*;
import Model.*;


public class ViewMovieDetailUI {
	/** 
     * Movie controller
     */
    private MoviesController moviesCtrl;

    /** 
     * Default constructor
     */
    ViewMovieDetailUI() {
        this.moviesCtrl = new MoviesController();
    }
    
    /** 
     * Constructor with controller's state
     * @param moviesCtrl	State of movie controller
     */
    ViewMovieDetailUI(MoviesController moviesCtrl) {
        this.moviesCtrl = moviesCtrl;
    }
    /** 
     * Main method for the UI - ask for the movie ID then print the details of that movie
     */
    public void main(){
        System.out.println("Enter movie ID to view movie detail (-1 to exit): ");
        int id = InputController.getIntFromUser();
        if(id == -1){
            return;
        }
        Movie movie = moviesCtrl.readByID(id);
        if(movie == null){
            System.out.println("Movie with this id doesn't exist!\n     Returning to main menu...");
        }
        else{
            String movieString = movie.toString();
            System.out.println(movieString);
        }
    }   
}
