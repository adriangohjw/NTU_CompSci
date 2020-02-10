package BusinessLayer;

import java.util.ArrayList;

import CustomException.CinemasExceptions.ExistingCinemaException;
import CustomException.CinemasExceptions.CinemaCodeNot3CharException;
import CustomException.CinemasExceptions.EmptyStringException;

import Model.Cinema;
import Model.CinemaType;
import Model.SeatingPlan;
import Controller.CinemasController;

public class CinemasLayer {

    static CinemasController cinemasCtrl = new CinemasController();

    
    /** 
     * Check if cinema can be created based on parameters passed
     * @param cineplexName  Name of Cineplex that this cinema will be added to
     * @param code          Cinema's code
     * @param cinemaType    Cinema's type
     * @param seatingPlan   Cinema's seating plan
     * @return              Return true if cinema can be created, else false
     */
    public static boolean isCinemaValid(String cineplexName, String code, CinemaType cinemaType, SeatingPlan seatingPlan){
        
        boolean isValid = true;

        if (isExistingCinema(code))
            try {
                throw new ExistingCinemaException();
            } catch (ExistingCinemaException e) {
                System.out.println(e.getMessage());
            }
            isValid = false;
        
        if (isCinemaCode3Char(code) == false) 
            isValid = false;

        if (isEmpty_code(code))
            isValid = false;

        return isValid;
    }

    
    /** 
     * Check if cinema exist based on cinema code passed
     * @param code      Cinema code to check for
     * @return boolean  Return true if cinema already exist, else false
     */
    public static boolean isExistingCinema(String code) {

        ArrayList<Cinema> allCinemas = cinemasCtrl.read();

        for (int i=0; i<allCinemas.size(); i++) {
            if (allCinemas.get(i).getCode().equals(code))
                return true;
        }

        return false;
    }

    
    /** 
     * Check if cinema code is 3 character in length
     * @param code      Cinema code to check for
     * @return boolean  Return true if length of cinema code is 3 characters, else false 
     */
    public static boolean isCinemaCode3Char(String code) {
        if (code.length() != 3) {
            try {
                throw new CinemaCodeNot3CharException();
            } catch (CinemaCodeNot3CharException e) {
                System.out.println(e.getMessage());
            }
            return false;
        } else {
            return true;
        }
    }

    
    /** 
     * Check if cinema code is empty
     * @param code      Cinema code to check for
     * @return boolean  Return true if cinema code is empty, else false
     */
    public static boolean isEmpty_code(String code) {
        if (isStringEmpty(code)){
            try {
                throw new EmptyStringException("code");
            } catch (EmptyStringException e) {
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
}