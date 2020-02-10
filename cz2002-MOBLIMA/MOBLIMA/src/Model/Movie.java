package Model;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * Represents a Movie 
 */
@SuppressWarnings("serial")
public class Movie implements Serializable {

    /**
     * This movie's unique ID
     */
    private int id;

    /**
     * This movie's title
     */
    private String title;

    /**
     * This movie's type
     */
    private MovieType type;

    /**
     * This movie's synopsis
     */
    private String synopsis;

    /**
     * This movie's rating
     */
    private String rating;

    /**
     * This movie's duration
     */
    private double duration;

    /**
     * This movie's release date
     */
    private LocalDate movieReleaseDate;

    /**
     * This movie's end date
     */
    private LocalDate movieEndDate;

    /**
     * This movie's director
     */
    private String director;

    /** 
     * This movie's list of cast 
     */
    private ArrayList<String> cast;

    /**
     * This movie's list of reviews
     */
    private ArrayList<Review> reviews; 
    

    
    /** 
     * Creates a Movie with the given attribute
     * Default for reviews is empty (no reviews assigned to movie during movie listing)
     * @param id                    This Movie's unique ID
     * @param title                 This Movie's title
     * @param type                  This Movie's type
     * @param synopsis              This Movie's synopsis
     * @param rating                This Movie's rating
     * @param duration              This Movie's duration (in hours) e.g. 1.5 == 1hours 30mins
     * @param movieReleaseDate      This Movie's release date
     * @param movieEndDate          This Movie's end date
     * @param director              This Movie's director
     * @param cast                  This Movie's list of casts
     */
    public Movie(
            int id, String title, MovieType type, String synopsis, String rating, double duration, LocalDate movieReleaseDate, LocalDate movieEndDate, String director, ArrayList<String> cast
    ){
        this.id = id;
        this.title = title;
        this.type = type;
        this.synopsis = synopsis;
        this.rating = rating;
        this.duration = duration; 
        this.movieReleaseDate = movieReleaseDate;
        this.movieEndDate = movieEndDate;
        this.director = director;
        this.cast = cast;
        this.reviews = new ArrayList<Review>();
    }

    
    /** 
     * Get the unique ID of this Movie
     * @return int      Unique ID of this Movie
     */
    public int getId() {
        return this.id;
    }
    
    
    /** 
     * Change the unique ID of this Movie
     * @param id    New unique ID of this Movie
     */
    public void setId(int id) {
        this.id = id;
    }

	
    /** 
     * Get the title of this Movie
     * @return String   Title of this Movie
     */
    public String getTitle() {
        return this.title;
    }
    
    
    /** 
     * Set the title of this Movie
     * @param title     New title of this Movie
     */
    public void setTitle(String title){
        this.title = title;
    }

    
    /** 
     * Get the MovieType of this Movie
     * @return MovieType    MovieType of this Movie
     */
    public MovieType getType(){
        return this.type;
    }
    
    
    /** 
     * Change the MovieType of this Movie
     * @param type  New MovieType of this Movie
     */
    public void setType(MovieType type){
        this.type = type;
    }

    
    /** 
     * Get the synopsis of this Movie
     * @return String   Synopsis of this Movie
     */
    public String getSynopsis(){
        return this.synopsis;
    }
    
    
    /** 
     * Change the synopsis of this Movie
     * @param synopsis      New synopsis of this Movie    
     */
    public void setSynopsis(String synopsis){
        this.synopsis = synopsis;
    }
    
    
    /** 
     * Get the rating of this Movie
     * @return String       Rating of this Movie
     */
    public String getRating() {
        return this.rating;
    }
    
    
    /** 
     * Change the rating of this Movie
     * @param rating    New rating of this Movie
     */
    public void setRating(String rating){
        this.rating = rating;
    }

    
    /** 
     * Get the duration of this Movie
     * @return double       Duration of this Movie
     */
    public double getDuration() {
        return this.duration;
    }
    
    
    /** 
     * Change the duration of this Movie
     * @param duration      New duration of this Movie
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    
    /** 
     * Get the release date of this Movie
     * @return LocalDate    Release date of this Movie
     */
    public LocalDate getMovieReleaseDate(){
        return this.movieReleaseDate;
    }
    
    
    /** 
     * Change the release date of this Movie
     * @param movieReleaseDate      New release date of this Movie
     */
    public void setMovieReleaseDate(LocalDate movieReleaseDate){
        this.movieReleaseDate = movieReleaseDate;
    }

    
    /** 
     * Get the release date of this Movie in another format
     * Mainly for readability reason
     * @return String   Release date of this Movie in the format of "EEEE, dd/MM/yyyy"
     */
    public String getMovieReleaseDateToString(){
        return movieReleaseDate.format(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy"));
    }

    
    /** 
     * Get the end date of this Movie in another format
     * Mainly for readability reason
     * @return String   End date of this Movie in the format of "EEEE, dd/MM/yyyy"
     */
    public String getMovieEndDateToString(){
        return movieEndDate.format(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy"));
    }

    
    /** 
     * Get the end date of this Movie
     * @return LocalDate    End date of this Movie
     */
    public LocalDate getMovieEndDate(){
        return this.movieEndDate;
    }
    
    
    /** 
     * Change the end date of this Movie
     * @param movieEndDate  New end date of this Movie
     */
    public void setMovieEndDate(LocalDate movieEndDate){
        this.movieEndDate = movieEndDate;
    }
    
    
    /** 
     * Get the director for this Movie
     * @return String       Director of this Movie
     */
    public String getDirector(){
        return this.director;
    }
    
    
    /** 
     * Change the director for this Movie
     * @param director      New director of this Movie
     */
    public void setDirector(String director){
        this.director = director;
    }

    
    /** 
     * Get the list of casts for this Movie
     * @return String    List of casts of this Movie
     */
    public ArrayList<String> getCast(){
        return this.cast;
    }
    
    
    /** 
     * Change the list of casts for this Movie
     * @param cast      New list of casts of this Movie
     */
    public void setCast(ArrayList<String> cast){
        this.cast = cast;
    }

    
    /** 
     * Get the list of reviews for this Movie
     * @return Model.{@link Review}    List of reviews for this Movie
     */
    public ArrayList<Review> getReviews(){
        return this.reviews;
    }
    
    
    /** 
     * Change the list of Movie for this Movie
     * @param reviews   New list of reviews for this Movie
     */
    public void setReviews(ArrayList<Review> reviews){
        this.reviews = reviews;
    }

    
    /** 
	 * String to return when this Movie is being called
	 * @return String
	 */
    public String toString(){
        String castString = "";
        for (int i=0; i<getCast().size(); i++)
            castString = castString.concat(getCast().get(i) + ",");
        castString = castString.substring(0, castString.length()-1);

        String reviews = "";
        for(int i = 0; i<getReviews().size();i++){
            reviews += getReviews().get(i).toString() + "\n\n";
        }
        if(reviews.equals(""))
            reviews = "N/A";

        String details = "";
        details += "ID: " + getId() + "\n"
                + "Title: " + getTitle() + "\n"
                + "Type: " + getType() + "\n"
                + "Status: " + getShowStatus().toString() + "\n"
                + "Synopsis: " + getSynopsis() + "\n"
                + "Rating: " + getRating() + "\n"
                + "Duration: " + String.valueOf(getDuration()) + " hour(s)\n"
                + "Release date: " +  getMovieReleaseDateToString() + "\n"
                + "End date: " +  getMovieEndDateToString() + "\n"
                + "Director: " + getDirector() + "\n"
                + "Cast: " + castString + "\n"
                + "Overall review rating: " + getOverallReviews() + "\n"
                + "Reviews: \n\n" + reviews;
        return details + "\n";
    }

    
    /** 
     * Get the overall (Average) number of stars for this Movie
     * If no review for this movie at the moment, return "N/A"
     * @return String   Overall number of stars of this Movie
     */
    public String getOverallReviews(){
        double sum = 0;
        if(reviews.size()>1){
            for(Review review : reviews){
                sum += review.getNumOfStars();
            }
            DecimalFormat df = new DecimalFormat("#.##");
            return df.format(sum/reviews.size());
        }
        else {
            return "N/A";
        }
    }

    
    /** 
     * Get the screening status of the Movie
     * Screening status derived from finding the difference between the start/end date and today's date
     * If today's date is after the end date of the movie, it will display "END OF SHOWING"
     * Else, if days difference between today and Movie's start date is more than 7, it is "COMING SOON"
     * Else, if days difference between today and Movie's start date is less than 7, it is "PREVIEW"
     * Else, if today is after Movie's start date and before Movie's end date, it is "NOW SHOWING"
     * @return MovieStatus  Screening status of the movie
     */
    public MovieStatus getShowStatus() {
        LocalDate current = LocalDate.now();
        if (current.isAfter(movieEndDate))
            return MovieStatus.END_OF_SHOWING;
        else {
            float daysBetween = Duration.between(current.atStartOfDay(), movieReleaseDate.atStartOfDay()).toDays();
            if (daysBetween > 7) {
                return MovieStatus.COMING_SOON;
            } else if (daysBetween <= 7 && daysBetween > 0) {
                return MovieStatus.PREVIEW;
            } else {
                return MovieStatus.NOW_SHOWING;
            }
        }
    }

    
    /** 
     * Compare and check if object is identical to this Movie
     * @param movie     item to be compared to
     * @return boolean  Return true if item is identical to this Movie, else false
     */
    @Override
    public boolean equals(Object movie) {
        if (!(movie instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) movie;
        return 
            this.id == other.getId()
            && this.title.equals(other.getTitle()) 
            && this.type.equals(other.getType()) 
            && this.synopsis.equals(other.getSynopsis()) 
            && this.rating.equals(other.getRating())
            && this.movieReleaseDate.equals(other.getMovieReleaseDate()) 
            && this.movieEndDate.equals(other.getMovieEndDate()) 
            && this.director.equals(other.getDirector()) 
            && this.cast.equals(other.getCast()) 
            && this.reviews.equals(other.getReviews());
    }
}
