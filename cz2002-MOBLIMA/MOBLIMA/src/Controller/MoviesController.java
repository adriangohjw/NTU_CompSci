package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import BusinessLayer.MoviesLayer;
import Model.Movie;
import Model.MovieStatus;
import Model.MovieType;
import Model.Review;

public class MoviesController {

    /**
     * The file name of the database file that this controller will access
     */
    public final static String FILENAME = "MOBLIMA/database/movies.txt";

    /**
     * The Review Controller that this controller will reference
     */
    public SessionsController sessionsCtrl;
    
    /**
     * Default Constructor
     */
    public MoviesController() {
        this.sessionsCtrl = new SessionsController();
    } 

    /** 
     * Parameterized constructor with user-defined Session Controller
     * @param sessionsCtrl    Non-default Session Controller to be referenced instead
     */
    public MoviesController(SessionsController sessionsCtrl) {
        this.sessionsCtrl = sessionsCtrl;
    } 

    /**
     * Declaring constant for better readability and easier referencing to attribute
     */
    public final static int ID = 0;
    public final static int TITLE = 1;
    public final static int TYPE = 2;
    public final static int SYNOPSIS = 3;
    public final static int RATING = 4;
    public final static int DURATION = 5;
    public final static int MOVIE_RELEASE_DATE = 6;
    public final static int MOVIE_END_DATE = 7;
    public final static int DIRECTOR = 8;
    public final static int CAST = 9;
    public final static int REVIEWS = 10;

    
    /** 
     * CREATE a new Movie and add it into the database file
     * Attributes are validated before creation
     * If attributes are not allowed, throw error and do nothing
     * If Database file exist, existing records are read and new Movie object is aopended before saving
     * If Database file does not exist, Movie object will be written to a new file and saved
     * @param title             This movie's title
     * @param type              This movie's type
     * @param synopsis          This movie's synopsis
     * @param rating            This movie's rating
     * @param duration          This movie's duration
     * @param movieReleaseDate  This movie's release date
     * @param movieEndDate      This movie's end date
     * @param director          This movie's director
     * @param cast              This movie's list of cast
     */
    public void create(String title, MovieType type, String synopsis, String rating, double duration,
            LocalDate movieReleaseDate, LocalDate movieEndDate, String director, ArrayList<String> cast) {
        if (MoviesLayer.isMovieValid(title, type, synopsis, rating, duration, movieReleaseDate, movieEndDate,
                director, cast)) {
            Movie movie = new Movie(getLastId() + 1, title, type, synopsis, rating, duration, movieReleaseDate,
                    movieEndDate, director, cast);
            ArrayList<Movie> allData = new ArrayList<Movie>();
            File tempFile = new File(FILENAME);
            if (tempFile.exists())
                allData = read();
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
                allData.add(movie);
                out.writeObject(allData);
                out.flush();
                out.close();
            } catch (IOException e) {
                // ignore error
            }
        } else {
            // do nothing
        }
    } 

    
    /** 
     * READ and return every Movies in the Database file
     * @return Movie    Return list of Movies if found, else empty list
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Movie> read() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));   
            ArrayList<Movie> movieListing = (ArrayList<Movie>) ois.readObject();
            ois.close();
            return movieListing;
        } catch (ClassNotFoundException | IOException e) {
            // ignore error
        } 
        return new ArrayList<Movie>();
    }

    
    /** 
     * READ and return every Movie of a given ID in the Database file
     * @param valueToSearch     Id of movie to search for
     * @return Movie            Return Movie if found, else null object
     */
    public Movie readByID(int valueToSearch) {
        ArrayList<Movie> allData = read();
        for (int i=0; i<allData.size(); i++){
            Movie m = allData.get(i);
            if (m.getId() == valueToSearch)
                return m;
        }
        return null;
    }

    
    /** 
     * READ and return every Movie based on a certain value of a given attribute in the Database file
     * @param col                   Given attribute to be check for (based on constant as defined)
     * @param valueToSearch         Value of given attribute to search for
     * @return Movie                Return list of Movies if any, else empty list
     */
    public ArrayList<Movie> readByAttribute(int col, Object valueToSearch) {
        ArrayList<Movie> allData = read();
        ArrayList<Movie> returnData = new ArrayList<Movie>();
        for (int i=0; i<allData.size(); i++){
            Movie m = allData.get(i);

            switch(col) {
                case TITLE:
                    if (m.getTitle().equals((String) valueToSearch))
                        returnData.add(m);
                    break;
                case TYPE:
                    if (m.getType().toString().equals((String) valueToSearch))
                        returnData.add(m);
                    break;
                case RATING:
                    if (m.getRating().equals((String) valueToSearch))
                        returnData.add(m);
                    break;
                case MOVIE_RELEASE_DATE:
                    if (m.getMovieReleaseDate().equals((LocalDate) valueToSearch))
                        returnData.add(m);
                    break;
                case MOVIE_END_DATE:
                    if (m.getMovieEndDate().equals((LocalDate) valueToSearch))
                        returnData.add(m);
                    break;
                default:   
                    System.out.println(".....readByAttribute NOT ALLOWED");
                    break;
            }
        }
        return returnData;
    }


    /**
     * READ and return every Movie that are still available for booking in the Database file
     * @return Movie    Return list of Movies if any, else empty list
     */
    public ArrayList<Movie> readAvailableMovies() {
        ArrayList<Movie> allData = read();
        ArrayList<Movie> returnData = new ArrayList<Movie>();
        
        for (Movie movie : allData) {
            MovieStatus movieShowStatus = movie.getShowStatus();
            if (movieShowStatus == MovieStatus.PREVIEW || movieShowStatus == MovieStatus.NOW_SHOWING) 
                returnData.add(movie);
        }
        
        return returnData;
    }
    
    /** 
     * UPDATE a Movie's attribute based on a given movie's id in Database file 
     * @param col           Attribute of movie to update
     * @param id            ID of Movie to search for    
     * @param newValue      New value of Movie's attribute
     */
    @SuppressWarnings("unchecked")
    public void updateById(int col, int id, Object newValue) {
        ArrayList<Movie> allData = read();
        ArrayList<Movie> returnData = new ArrayList<Movie>();

        // Delete Sessions with MovieID equal to MovieID passed in
        sessionsCtrl.updateByMovie(col, id, newValue);
                
        for (int i=0; i<allData.size(); i++){
            Movie m = allData.get(i);
            if (m.getId() == id){
                switch(col) {

                    case ID:
                        m.setId((int) newValue);
                        break;

                    case TITLE:
                        if (MoviesLayer.isEmpty_title((String) newValue)) {
                            // do nothing
                        } else {
                            m.setTitle((String) newValue);
                        }
                        break;

                    case TYPE:
                        m.setType((MovieType) newValue);
                        break;

                    case SYNOPSIS:
                        if (MoviesLayer.isEmpty_synopsis((String) newValue)) {
                            // do nothing
                        } else {
                            m.setSynopsis((String) newValue);
                        }
                        break;

                    case RATING:
                        if (MoviesLayer.isEmpty_rating((String) newValue)) {
                            // do nothing
                        } else {
                            m.setRating((String) newValue);
                        }
                        break;

                    case DURATION:
                        if (MoviesLayer.isDurationNegative((double) newValue)) {
                            // do nothing
                        } else {
                            m.setDuration((double) newValue);
                        }
                        break;

                    case MOVIE_RELEASE_DATE:
                        if (MoviesLayer.areDatesValid((LocalDate) newValue, m.getMovieEndDate())) {
                            m.setMovieReleaseDate((LocalDate) newValue);
                        } else {
                            // do nothing
                        }
                        break;

                    case MOVIE_END_DATE:
                        if (MoviesLayer.areDatesValid(m.getMovieReleaseDate(), (LocalDate) newValue)) {
                            m.setMovieEndDate((LocalDate) newValue);
                        } else {
                            // do nothing
                        }
                        break;

                    case DIRECTOR:
                        if (MoviesLayer.isEmpty_director((String) newValue)) {
                            // do nothing
                        } else {
                            m.setDirector((String) newValue);
                        }
                        break;

                    case CAST:
                        if (MoviesLayer.isEmpty_cast((ArrayList<String>) newValue)) {
                            // do nothing
                        } else {
                            m.setCast((ArrayList<String>) newValue);
                        }
                        break;

                    case REVIEWS:
                        m.setReviews((ArrayList<Review>) newValue);
                        break;

                    default:   
                        break;
                }
            }
            returnData.add(m);
        }

        replaceExistingFile(FILENAME, returnData);
    }

    
    /**
     * Delete a Movie in the Database file, based on the ID attribute passed 
     * @param id    ID of Movie which will be deleted
     */
    public void deleteById(int id) {
        ArrayList<Movie> allData = read();
        ArrayList<Movie> returnData = new ArrayList<Movie>();

        // Delete Sessions with MovieID equal to MovieID passed in
        sessionsCtrl.deleteByMovie(id);
        
        for (int i=0; i<allData.size(); i++){
            Movie m = allData.get(i);
            if (!(m.getId() == id))
                returnData.add(m);
        }

        replaceExistingFile(FILENAME, returnData);
    }

    
    /** 
     * Return the ID of the last Movie in the Database field
     * @return int      ID of last Movie in the Database
     */
    public int getLastId(){
        int lastId = -1;
        int movieID;
        ArrayList<Movie> allData = read();
        for (int i=0; i<allData.size(); i++){
            movieID = allData.get(i).getId();
            if (movieID > lastId)
                lastId = movieID;
        }
        return lastId;
    }

    
    /** 
     * Overwrite Database file with new data of list of Admin
     * @param filename      Filename to check for
     * @param data          New ArrayList of Movies to be written to the file
     */
    public void replaceExistingFile(String filename, ArrayList<Movie> data){
        File tempFile = new File(filename);
        if (tempFile.exists()) 
            tempFile.delete();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(data);
            out.flush();
            out.close();
        } catch (IOException e) {
            //
        }
    }
}