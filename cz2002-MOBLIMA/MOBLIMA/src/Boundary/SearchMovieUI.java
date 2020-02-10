package Boundary;

import Controller.*;
import Model.*;

import java.util.*;

public class SearchMovieUI {
	/** 
     * Variables to store movie title, movie type and user's choice in display() method
     */
    private String title;
    private String type;
    private int option;
    
    /** 
     * All controllers (movie)
     */
    private MoviesController moviesCtrl;

    /** 
     * Default constructor
     */
    SearchMovieUI() {
        this.moviesCtrl = new MoviesController();
    }
    /** 
     * Default constructor with controller's state
     * @param moviesCtrl	State of movie controller
     */
    SearchMovieUI(MoviesController moviesCtrl) {
        this.moviesCtrl = moviesCtrl;
    }

    /** 
     * Main method for the UI - display while not quitting
     */
    public void main(){
        while (option!=4) {
            display();
        }
    }

    /** 
     * Display all search options and ask user to choose one
     */
    public void display(){
        System.out.println("1. Search by movie title");
        System.out.println("2. Search by movie type");
        System.out.println("3. List all movie title");
        System.out.println("4. Exit");
        switch (option = InputController.getIntFromUser()) {
        case 1:
            searchByTitle();
            break;
        case 2:
            searchByType();
            break;
        case 3:
            listAllMovies();
            break;
        case 4:
            System.out.println("Exit!");
            return;
        default:
            System.out.println("Invalid input! Please try again.");
        }
    }

    /** 
     * Searching a movie by title
     * @return If there is a movie for that title 
     */
    public boolean searchByTitle(){
        System.out.println("Enter movie title: ");
        title = InputController.getStringFromUser();
        ArrayList<Movie> movieList = moviesCtrl.readByAttribute(moviesCtrl.TITLE, title);
        if(movieList.isEmpty()){
            System.out.println("No search results matching given title!");
            return false;
        }
        else{
            movieList.forEach(movie -> printMovie(movie));
            return true;
        }
    }
    /** 
     * Searching a movie by type
     * @return If there is a movie for that type
     */
    public boolean searchByType(){
        System.out.println("Enter movie type: ");
        type = InputController.getStringFromUser();
        ArrayList<Movie> movieList = moviesCtrl.readByAttribute(moviesCtrl.TYPE, type);
        if(movieList.isEmpty()){
            System.out.println("No search results matching given type!");
            return false;
        }
        else{
            movieList.forEach(movie -> printMovie(movie));
            return true;
        }
    }
   
    /** 
     * List all available movies
     * @return boolean  return true if movie list is not empty, else false
     */
    public boolean listAllMovies(){
        ArrayList<Movie> movieList = moviesCtrl.read();
        if(movieList.isEmpty()){
            System.out.println("No movies to be listed!");
            return false;
        }
        else{
            movieList.forEach(movie -> printMovie(movie));
            return true;
        }
    }
    
    /** 
     * Print a movie's detail
     * @param movie		Movie to print the details
     */
    public void printMovie(Movie movie){
        int id = movie.getId();
        String title = movie.getTitle();
        String releaseDate = movie.getMovieReleaseDateToString();
        String movieString = "Movie ID: " + id + "\n" + "Title: " + title + "\n" + "Release Date: " + releaseDate;
        System.out.println(movieString);
        System.out.println("-------------------");
    }
}
