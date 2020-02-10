package BusinessLayer;

import java.time.LocalDate;
import java.util.ArrayList;

import Controller.MoviesController;
import CustomException.MoviesExceptions.ExistingMovieException;
import CustomException.MoviesExceptions.EmptyCastException;
import CustomException.MoviesExceptions.EmptyStringException;
import CustomException.MoviesExceptions.EndBeforeReleaseException;
import CustomException.MoviesExceptions.NegativeDurationException;
import Model.Movie;
import Model.MovieStatus;
import Model.MovieType;

public class MoviesLayer {

    static MoviesController moviesCtrl = new MoviesController();

    
    /** 
     * Check if movie can be created based on parameters passed
     * @param title             Movie's title
     * @param type              Movie's type
     * @param synopsis          Movie's synopsis
     * @param rating            Movie's rating
     * @param duration          Movie's duration
     * @param movieReleaseDate  Movie's release date
     * @param movieEndDate      Movie's end date
     * @param director          Movie's director
     * @param cast              Movie's cast
     * @return boolean          Return true if movie can be created, else false
     */
    public static boolean isMovieValid(
        String title, MovieType type, String synopsis, String rating, double duration, LocalDate movieReleaseDate, LocalDate movieEndDate, String director, ArrayList<String> cast
    ) {
        boolean isValid = true;

        if (isExistingMovie(title)){
            try {
                throw new ExistingMovieException();
            } catch (ExistingMovieException e) {
                System.out.println(e.getMessage());
            }
            isValid = false;
        }
            
        if (isEmpty_title(title))
            isValid = false;

        if (isEmpty_synopsis(synopsis))
            isValid = false;

        if (isEmpty_rating(rating))
            isValid = false;

        if (isDurationNegative(duration))
            isValid = false;

        if (areDatesValid(movieReleaseDate, movieEndDate) == false) 
            isValid = false;

        if (isEmpty_director(director))
            isValid = false;

        if (isEmpty_cast(cast))
            isValid = false;
        
        return isValid;
    }

    
    /** Check if movie exist based on movie's title passed
     * @param title     Movie's name to check for
     * @return boolean  Return true if movie already exist, else false
     */
    public static boolean isExistingMovie(String title) {
        ArrayList<Movie> allMovies = moviesCtrl.read();
        for (Movie movie : allMovies) {
            if (movie.getTitle().equals(title))
                return true;
        }
        return false;
    }

    
    /** Check if movie's title is empty
     * @param title     Movie's title to check for
     * @return boolean  Return true if movie's title is empty, else false
     */
    public static boolean isEmpty_title(String title) {
        if (isStringEmpty(title)){
            try {
                throw new EmptyStringException("title");
            } catch (EmptyStringException e) {
                System.out.println(e.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }

    
    /** Check if movie's synopsis is empty
     * @param synopsis  Movie's synopsis to check for
     * @return boolean  Return true if movie's synopsis is empty, else false
     */
    public static boolean isEmpty_synopsis(String synopsis) {
        if (isStringEmpty(synopsis)){
            try {
                throw new EmptyStringException("synopsis");
            } catch (EmptyStringException e) {
                System.out.println(e.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }

    
    /** Check if movie's rating is empty
     * @param rating    Movie's rating to check for
     * @return boolean  Return true if movie's rating is empty, else false
     */
    public static boolean isEmpty_rating(String rating) {
        if (isStringEmpty(rating)){
            try {
                throw new EmptyStringException("rating");
            } catch (EmptyStringException e) {
                System.out.println(e.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }

    
    /** Check if movie's duration is negative
     * @param duration  Movie's duration to check for
     * @return boolean  Return true if movie's duration is negative, else false
     */
    public static boolean isDurationNegative(double duration){
        if (duration < 0){
            try {
                throw new NegativeDurationException();
            } catch (NegativeDurationException e) {
                System.out.println(e.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }

    
    /** Check if movie's end date is before the release date
     * @param movieReleaseDate  Movie's release date to check for
     * @param movieEndDate      Movie's end date to check for
     * @return boolean          Return true if end date is before release date, else false
     */
    public static boolean areDatesValid(LocalDate movieReleaseDate, LocalDate movieEndDate){
        if (movieReleaseDate.isBefore(movieEndDate)){
            return true;
        } else {
            try {
                throw new EndBeforeReleaseException();
            } catch (EndBeforeReleaseException e) {
                System.out.println(e.getMessage());
            }
            return false;
        }
    }

    
    /** Check if movie's director is empty
     * @param director  Movie's director to check for
     * @return boolean  Return true if movie's diirector is empty, else false
     */
    public static boolean isEmpty_director(String director) {
        if (isStringEmpty(director)){
            try {
                throw new EmptyStringException("director");
            } catch (EmptyStringException e) {
                System.out.println(e.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }

    
    /** Check if movie's list of cast is empty
     * @param cast      Movie's list of cast to check for
     * @return boolean  Return true if movie's list of cast is empty, else false
     */
    public static boolean isEmpty_cast(ArrayList<String> cast) {
        if (cast.isEmpty()){
            try {
                throw new EmptyCastException();
            } catch (EmptyCastException e) {
                System.out.println(e.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }

    
    /** 
     * Check if a string is empty
     * @param item      String to check for
     * @return boolean  Return true if string is empty, else false
     */
    private static boolean isStringEmpty(String item) {
        return item.equals("");
    }

    
    /**
     * Check if movie is available for booking based on the show status
     * @param movie     Movie to check for
     * @return boolean  Return true if movie is available for booking, else false
     */
    public static boolean isAvailableForBooking(Movie movie){
        MovieStatus showStatus = movie.getShowStatus();
        if (showStatus == MovieStatus.PREVIEW || showStatus == MovieStatus.NOW_SHOWING) 
            return true;
        else    
            return false;
    }
}