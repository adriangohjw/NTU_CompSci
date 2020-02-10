package BusinessLayer;

import Controller.TransactionsController;

import Model.Movie;

import CustomException.TransactionsExceptions.InvalidTransactionException;

public class TransactionsLayer {
    
    static TransactionsController transactionsCtrl = new TransactionsController();

    
    /** 
     * Check if transaction can be created based on parameters passed
     * @param cinemaCode    Code of cinema that this transaction is made for
     * @param name          Name of user booking the ticket(s)
     * @param email         Email of user booking the ticket(s)
     * @param mobileNumber  Mobile number of user booking the ticket(s)
     * @param movie         Movie in which this transaction is made for
     * @return boolean      Return true if transaction can be created, else false
     */
    public static boolean isTransactionValid(String cinemaCode, String name, String email, String mobileNumber, Movie movie){

        boolean isValid = true;

        if(CinemasLayer.isExistingCinema(cinemaCode) == false)
            isValid = false;

        if(MoviesLayer.isAvailableForBooking(movie) == false)
            isValid = false;

        if (!isValid){
            try {
                throw new InvalidTransactionException();
            } catch (InvalidTransactionException e) {
                System.out.println(e.getMessage());
            }
        }

        return isValid;
    }
}