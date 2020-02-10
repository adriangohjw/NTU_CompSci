package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a Holiday for the system to referenced
 * Mainly used to determine any markup in the price of ticket(s)
 */
@SuppressWarnings("serial")
public class Holiday implements Serializable {

    /**
     * this Holiday's date
     */
    private LocalDate holidayDate;

    
    /** 
     * Creates a Holiday with the given date
     * @param holidayDate   this Holiday's date
     */
    public Holiday(LocalDate holidayDate){
        this.holidayDate = holidayDate;
    }

    
    /** 
     * Get the date of this Holiday
     * @return LocalDate    this Holiday's date
     */
    public LocalDate getHolidayDate(){
        return this.holidayDate;
    }
    
    
    /** 
     * Change the date of this Holiday
     * @param holidayDate   this Holiday's new date
     */
    public void setHolidayDate(LocalDate holidayDate) {
        this.holidayDate = holidayDate;
    }

    
    /** 
     * Converting this Holiday's date to a string format for readability reason
     * @return String   another format of this Holiday's date
     */
    public String getHolidayDateToString(){
        return holidayDate.format(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy"));
    }

    
    /** 
     * String to return when this Movie_Goer is being called
     * @return String
     */
    public String toString() {
        return "The holiday is on " + this.getHolidayDateToString();
    }
}