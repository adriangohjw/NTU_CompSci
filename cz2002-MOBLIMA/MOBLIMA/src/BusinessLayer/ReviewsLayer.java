package BusinessLayer;

import java.util.ArrayList;

import Controller.MoviesController;
import CustomException.ReviewsException.StarsOutOfRangeException;

import Model.Movie;
import Model.Review;

public class ReviewsLayer {

    public static MoviesController moviesCtrl = new MoviesController();

    
    /** 
     * Check if review can be created based on parameters passed
     * @param movie                 Name of movie that this review will be added to
     * @param username              Username of the movie's reviewer
     * @param numOfStars            Number of stars given by reviewer
     * @param additionalComment     Addition remark given by reviewer (optional)
     * @return boolean
     */
    public static boolean isReviewValid(Movie movie, String username, double numOfStars, String additionalComment) {

        boolean isValid = true;

        if (isNumOfStarsValid(numOfStars) == false)
            isValid = false;

        if (isExistingReview(movie, username))
            isValid = false;

        return isValid;
    }

    
    /** 
     * Check if reviewer has already given his/her review for the movie
     * @param movie     Movie to check for
     * @param username  Username of reviewer to check for
     * @return boolean  Return true if review already exist, else false
     */
    public static boolean isExistingReview(Movie movie, String username) {
        if (MoviesLayer.isExistingMovie(movie.getTitle())){
            Movie movieInDB = moviesCtrl.readByID(movie.getId());
            ArrayList<Review> reviews = movieInDB.getReviews();
            for (Review review : reviews) {
                if (review.getUsername().equals(username))
                    return true;
            }
        } 
        return false;
    }

    
    /** 
     * Check if the number of stars given by the reviewer is in the valid range
     * @param numOfStars    Number of stars given by reviewer
     * @return boolean      Return true if number of stars given is in valid range, else false
     */
    public static boolean isNumOfStarsValid(double numOfStars) {
        if (numOfStars < 0 || numOfStars > 5) {
            try {
                throw new StarsOutOfRangeException();
            } catch (StarsOutOfRangeException e) {
                System.out.println(e.getMessage());
            }
            return false;
        } else {
            return true;
        }
    }
}