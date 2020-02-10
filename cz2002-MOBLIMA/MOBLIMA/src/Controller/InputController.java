package Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Class used to take input from user. Implemented to avoid multiple declaration of Scanner, which may lead to problems.
 * Set of static methods which return desired and validated user's input.
 */
public class InputController {

    /** Attribute scanner defined once,. */
    private static Scanner sc = new Scanner(System.in);

    /**
     * Get a non-empty string from user.
     * Ask for input until it is correct.
     * @return Non-empty String inserted by user
     */
    public static String getStringFromUser(){
        String input = "";
        while(input.equals("")){
            input = sc.nextLine();
            if(input.equals("")){
                System.out.println("Cannot be empty, try again!");
            }
        }
        return input;
    }

    /**
     * Get a string that matches email pattern from user.
     * Ask for input until it is correct.
     * @return Non-empty String that matches email pattern
     */
    public static String getEmailFromUser(){
        String pattern = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        String input = "";
        boolean validInput = false;
        while(!validInput){
            input = sc.nextLine();
            if(input.matches(pattern)){
                validInput = true;
            }
            else{
                System.out.println("Must match email pattern!");
            }
        }
        return input;
    }

    /**
     * Get a mobile number with valid Singapore pattern (8 digits, starts with 8 or 9)
     * Ask for input until it is correct.
     * @return Non-empty String that matches the pattern of mobile number in Singapore
     */
    public static String getMobileNumberFromUser(){
        String pattern = "\\d{8}";
        String input = "";
        boolean validInput = false;
        while(!validInput){
            input = sc.nextLine();
            if(input.matches(pattern) && (input.startsWith("9")||input.startsWith("8"))){
                validInput = true;
            }
            else{
                System.out.println("Must be valid mobile number (8 digits long, starts with either 8 or 9)");
            }
        }
        return input;
    }

    /**
     * Get an integer which indicate yes or no from user
     * Ask for input until it is correct.
     * @return Integer that equals to 0 or 1, based on user input
     */
    public static int getYesOrNoFromUser(){
        int input = -1;
        boolean validInput = false;
        while (!validInput){
            input = getIntFromUser();
            if(input==0 || input==1){
                validInput = true;
            }
            else{
                System.out.println("Must be either 0 or 1");
            }
        }
        return input;
    }

    /**
     * Get an integer from user.
     * Ask for input until it is correct.
     * @return Valid integer
     */
    public static int getIntFromUser(){
        int input = -1;
        boolean validInput = false;
        while(!validInput) {
            if(sc.hasNextInt()){
                input = sc.nextInt();
                validInput = true;
            }
            else{
                System.out.println("Wrong input!");
            }
            sc.nextLine();
        }
        return input;
    }

    /**
     * Get positive integer from user.
     * Ask for input until it is correct.
     * @return Positive integer (greater than 0)
     */
    public static int getPositiveIntFromUser(){
        int input = -1;
        boolean validInput = false;
        while(!validInput) {
            if(sc.hasNextInt()){
                input = sc.nextInt();
                if(input>0)
                    validInput = true;
            }
            else{
                System.out.println("Wrong input!");
            }
            sc.nextLine();
        }
        return input;
    }

    /**
     * Get a double between 0 and given range from user
     * Ask for input until it is correct.
     * @param range Maximum value of input
     * @return Double between 0 and given value
     */
    public static double getDoubleFromUser(int range){
        double input = -1;
        boolean validInput = false;
        while(!validInput) {
            if(sc.hasNextDouble()){
                input = sc.nextDouble();
                if(input>=0 && input<=5){
                    validInput = true;
                }
                else{
                    System.out.println("Must be within range 0-5! ");
                }
            }
            else{
                System.out.println("Must be double type! (decimal number)");
            }
            sc.nextLine();
        }
        return input;
    }

    /**
     * Get the date and time from user.
     * Ask for String input until it is correct (match pattern)
     * @return LocalDateTime based on user's input
     */
    public static LocalDateTime getDateTimeFromUser(){
        LocalDateTime result = null;
        String date;
        boolean validInput = false;
        while(!validInput){
            try{
                date = sc.nextLine();
                result = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                validInput = true;
            }
            catch(DateTimeParseException e){
                System.out.println("Must be of pattern DD/MM/YYYY HH:MM!");
            }
        }
        return result;
    }

    /**
     * Get the date from user.
     * Ask for String input until it is correct (match pattern)
     * @return LocalDate based on user's input
     */
    public static LocalDate getDateFromUser(){
        LocalDate result = null;
        String date;
        boolean validInput = false;
        while(!validInput){
            try{
                date = sc.nextLine();
                result = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                validInput = true;
            }
            catch(DateTimeParseException e){
                System.out.println("Must be of pattern DD/MM/YYYY!");
            }
        }
        return result;
    }

    /**
     * Get a double from user.
     * Ask for input until it is correct.
     * @return Valid double
     */
    public static double getDoubleFromUser(){
        double input = -1;
        boolean validInput = false;
        while(!validInput) {
            if(sc.hasNextDouble()){
                input = sc.nextDouble();
                validInput = true;
            }
            else{
                System.out.println("Must be a double type! (decimal number)");
            }
            sc.nextLine();
        }
        return input;
    }
}
