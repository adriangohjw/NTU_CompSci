package Controller;

import java.util.ArrayList;

import BusinessLayer.ReviewsLayer;
import Model.*;

public class ReviewsController {

    /**
     * The Movie Controller that this controller will reference
     */
    private MoviesController movieCtrl;

    /**
     * The file name of the database file that this controller will access
     */
    public String FILENAME;

    
    /** 
     * Default constructor
     */
    @SuppressWarnings("static-access")
    public ReviewsController(){
        this.movieCtrl = new MoviesController();
        this.FILENAME = movieCtrl.FILENAME;
    }

    
    /** 
     * Parameterized constructor with user-defined Movie Controller
     * @param movieCtrl     Non-default Movie Controller to be referenced instead
     */
    @SuppressWarnings("static-access")
    public ReviewsController(MoviesController movieCtrl){
        this.movieCtrl = movieCtrl;
        this.FILENAME = movieCtrl.FILENAME;
    }

    /** 
     * Gets the Movie Controller that this controller is referencing
     * @return MoviesController     This controller's Movie Controller
     */
    public MoviesController getMovieCtrl(){
        return this.movieCtrl;
    }

    /** 
     * Change the Movie Controller that this controller is referencing
     * @param moviesCtrl     This controller's new Movie Controller
     */
    public void setMoviesCtrl(MoviesController moviesCtrl){
        this.movieCtrl = moviesCtrl;
    }

    
    /** 
     * CREATE a new Review and add it into the database file
     * Attributes are validated before creation
     * If attributes are not allowed, throw error and do nothing
     * If Database file exist, existing records are read and new Review object is aopended before saving
     * If Database file does not exist, Review object will be written to a new file and saved
     * @param movie                 Movie that this Review will be added to
     * @param username              Username of Reviewer
     * @param numOfStars            Number of stars given by reviewer, between 0 - 5 (inclusive)
     * @param additionalComment     Additional comment given by Reviewer (optional)
     */
    public void create(Movie movie, String username, double numOfStars, String additionalComment) {
        if (ReviewsLayer.isReviewValid(movie, username, numOfStars, additionalComment)) {
            Review review = new Review(username, numOfStars, additionalComment);
            ArrayList<Movie> allData = this.movieCtrl.read();
            ArrayList<Movie> returnData = new ArrayList<Movie>();
            for (int i=0; i<allData.size(); i++){
                Movie m = allData.get(i);
                if (m.equals(movie)){
                    ArrayList<Review> reviews = m.getReviews();
                    reviews.add(review);
                    m.setReviews(reviews);
                }
                returnData.add(m);
            }
            this.movieCtrl.replaceExistingFile(FILENAME, returnData);
        } else {
            // do nothing
        }
    } 
}