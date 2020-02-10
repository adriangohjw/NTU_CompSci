package BusinessLayer;

import java.util.ArrayList;

import Controller.CineplexesController;
import Model.Cinema;
import Model.Cineplex;
import CustomException.CineplexesExceptions.EmptyStringException;
import CustomException.CineplexesExceptions.ExistingCineplexException;
import CustomException.CineplexesExceptions.LessThan3CinemasException;

public class CineplexesLayer {

    static CineplexesController cineplexesCtrl = new CineplexesController();

    
    /** 
     * Check if cineplex can be created based on parameters passed
     * @param name      Cineplex's name
     * @param cinemas   List of Cinemas in the Cineplex
     * @return boolean  Return true if cineplex can be created, else false
     */
    public static boolean isCineplexValid(String name, ArrayList<Cinema> cinemas) {

        boolean isValid = true;

        if (isExistingCineplex(name)){
            try {
                throw new ExistingCineplexException();
            } catch (ExistingCineplexException e) {
                System.out.println(e.getMessage());
            }
            isValid = false;
        }
        
        if (isEmpty_name(name))
            isValid = false;

        if (hasLessThan3Cinemas(cinemas))
            isValid = false;

        return isValid;
    }

    
    /** 
     * Check if cineplex exist based on cineplex's name passed
     * @param name      Cineplex's name to check for
     * @return boolean  Return true if cineplex already exist, else false
     */
    public static boolean isExistingCineplex(String name) {

        ArrayList<Cineplex> allCineplexes = cineplexesCtrl.read();

        for (int i=0; i<allCineplexes.size(); i++) {
            if (allCineplexes.get(i).getName().equals(name))
                return true;
        }
        return false;
    }

    
    /** 
     * Check if a list of cinemas has at least 3 cinemas
     * @param cinemas   List of cinemas to check for
     * @return boolean  Return true if list of cinemas already exist, else false
     */
    public static boolean hasLessThan3Cinemas(ArrayList<Cinema> cinemas) {
        if (cinemas.size() < 3) {
            try {
                throw new LessThan3CinemasException();
            } catch (LessThan3CinemasException e) {
                System.out.println(e.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }

    
    /** 
     * Check if cineplex name is empty
     * @param name      Cineplex's name to check for
     * @return boolean  Return true if cineplex's name is empty, else false
     */
    public static boolean isEmpty_name(String name) {
        if (isStringEmpty(name)){
            try {
                throw new EmptyStringException("name");
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