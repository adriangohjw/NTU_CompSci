package Model;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a Session 
 * Each session will be assigned to a particular cinema by the cinema's code
 */
@SuppressWarnings("serial")
public class Session implements Serializable {

    /**
     * The movie that will be screened during this Session
     */
    private Movie movie;

    /**
     * The date and time in which the screening session will begin
     */
    private LocalDateTime sessionDateTime;

    /**
     * Seats Availability of this Session
     */
    private SeatingPlan seatsAvailability;

    /**
     * Unique Session ID assigned to this Session
     */
    private int id;

    
    /** 
     * Creates a Session with the given attributes
     * @param movie             The movie that will be screened during this Session
     * @param sessionDateTime   The date and time in which the screening session will begin
     * @param seatingPlan       Seats Availability of this Session
     * @param id                Unique Session ID assigned to this Session
     */
    public Session(Movie movie, LocalDateTime sessionDateTime, SeatingPlan seatingPlan, int id) {
        this.movie = movie;
        this.sessionDateTime = sessionDateTime;
        this.seatsAvailability = seatingPlan;
        this.id = id;
    }

    
    /**
     * Get the movie that will be screened during this Session
     * @return Movie    Movie that will be screened
     */
    public Movie getMovie() {
        return movie;
    }

    
    /** 
     * Change the movie that will be screened during this Session
     * @param movie     New movie that will be screened
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    
    /** 
     * Get the date and time which the screening session will begin
     * @return LocalDateTime    Date and timm of the screening session
     */
    public LocalDateTime getSessionDateTime() {
        return sessionDateTime;
    }

    
    /** 
     * Change the date and time of this Session
     * @param sessionDateTime   New date and time of this Session
     */
    public void setSessionDateTime(LocalDateTime sessionDateTime) {
        this.sessionDateTime = sessionDateTime;
    }

    
    /** 
     * Get the Date and Time of this Session in another format
     * @return String   Date and time of Session in the format of "EEEE, dd/MM/yyyy HH:mm"
     */
    public String getSessionDateTimeToString() {
        return sessionDateTime.format(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy HH:mm"));
    }

    
    /** 
     * Get the seating plan of this Session
     * @return SeatingPlan  This Session's seating plan
     */
    public SeatingPlan getSeatsAvailability() {
        return this.seatsAvailability;
    }

    
    /** 
     * Get the seats availability of this Session
     * @param seatsAvailability This Session's seats availability
     */
    public void setSeatsAvailability(SeatingPlan seatsAvailability) {
        this.seatsAvailability = seatsAvailability;
    }

    
    /** 
     * Get the ID of this Session
     * @return int      This Session's unique ID
     */
    public int getId(){
        return this.id;
    }

    
    /** 
     * Set the ID of this Session
     * @param id        This Session's new unique ID
     */
    public void setId(int id){
        this.id = id;
    }

    
    /** 
     * Check if the session is considered a weekend
     * Mainly used to check if there will be any price markup
     * Friday after 6pm are considered Weekends too
     * @return boolean  Return true if session is considered a weekend, else False
     */
    public boolean isWeekend(){
        if(sessionDateTime.getDayOfWeek() == DayOfWeek.SATURDAY || sessionDateTime.getDayOfWeek() == DayOfWeek.SUNDAY){
            return true;
        }
        else if(sessionDateTime.getDayOfWeek() == DayOfWeek.FRIDAY && sessionDateTime.getHour()>18){
            return true;
        }
        else{
            return false;
        }
    }

    
    /**
     * Get the start time of this screening Session 
     * @return LocalTime    Start time of this Session
     */
    public LocalTime getStartTime() {
        return getSessionDateTime().toLocalTime();
    }

    
    /** 
     * Get the end time of this screening session
     * @return LocalTime    End time of this Session
     */
    public LocalTime getEndTime() {
        return getStartTime().plusMinutes((long) (60.0 * getMovie().getDuration()));
    }

    
    /** 
	 * String to return when this Movie_Goer is being called
	 * @return String	
	 */
    public String toString() {
        return "id: " + this.getId() + " Title: " + movie.getTitle() + ", DateTime: " + this.getSessionDateTime() + "is Weekend: " + isWeekend();
    }
}
