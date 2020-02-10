package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import BusinessLayer.UsersLayer;

import Model.*;

public class MovieGoersController {

    /**
     * File name of Database file to access
     */
    public final static String FILENAME = "MOBLIMA/database/movieGoers.txt";

    /**
     * Declaring constant for better readability and easier referencing to attribute
     */
    public final static int EMAIL = 0;
    public final static int PASSWORDHASHED = 1;
    public final static int ROLE = 2;
    public final static int NAME = 3;
    public final static int MOBILE_NUMBER = 4;

    
    /** 
     * CREATE a new MovieGoer and add it into the database file
     * Used for when we only know the username and encrypted password of the MovieGoer
     * Attributes are validated before creation
     * If attributes are not allowed, throw error and do nothing
     * If Database file exist, existing records are read and new MovieGoer object is aopended before saving
     * If Database file does not exist, MovieGoer object will be written to a new file and saved
     * @param username      MovieGoer's username
     * @param password      MovieGoer's password (non-encrypted)
     */
    public void create(String username, String password) {
        if (UsersLayer.isValidUser(username)) {
            try {
                Movie_Goer movieGoer = new Movie_Goer(username, password);
                ArrayList<Movie_Goer> allData = new ArrayList<Movie_Goer>();
                File tempFile = new File(FILENAME);
                if (tempFile.exists())
                    allData = read();
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
                allData.add(movieGoer);
                out.writeObject(allData);
                out.flush();
                out.close();
            } catch (IOException | NoSuchAlgorithmException e) {
                // ignore error
            }
        } else {
            // do nothing
        }
    }

    
    /** 
     * CREATE a new MovieGoer and add it into the database file
     * Used for when we know all the details of a MovieGoer
     * Attributes are validated before creation
     * If attributes are not allowed, throw error and do nothing
     * If Database file exist, existing records are read and new MovieGoer object is aopended before saving
     * If Database file does not exist, MovieGoer object will be written to a new file and saved
     * @param username      MovieGoer's username
     * @param password      MovieGoer's password (non-encrypted)
     * @param name          MovieGoer's name
     * @param mobileNumber  MovieGoer's mobile number
     */
    public void create(String username, String password, String name, String mobileNumber) {   
        if (!(UsersLayer.isValidUser(username))) {
            try {
                Movie_Goer movieGoer = new Movie_Goer(username, password, name, mobileNumber);
                ArrayList<Movie_Goer> allData = new ArrayList<Movie_Goer>();
                File tempFile = new File(FILENAME);
                if (tempFile.exists())
                    allData = read();
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
                allData.add(movieGoer);
                out.writeObject(allData);
                out.flush();
                out.close();
            } catch (IOException | NoSuchAlgorithmException e) {
                // ignore error
            }
        }
    }

    
    /** 
     * READ and return every Cineplex in the Database file
     * If Database file not found, ignore error and return empty list
     * @return Model.{@link Movie_Goer}  Return list of Cineplexes if any, else empty list
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Movie_Goer> read() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));
            ArrayList<Movie_Goer> movieGoerListing = (ArrayList<Movie_Goer>) ois.readObject();
            ois.close();
            return movieGoerListing;
        } catch (ClassNotFoundException | IOException e) {
            // ignore error
        }
        return new ArrayList<Movie_Goer>();
    }

    
    /** 
     * READ and return MovieGoer based on email passed in the Database file
     * @param valueToSearch     Email of MovieGoer to search for
     * @return Movie_Goer       Return MovieGoer if found, else null object
     */
    public Movie_Goer readByEmail(String valueToSearch) {
        ArrayList<Movie_Goer> allData = read();
        for (int i=0; i<allData.size(); i++){
            Movie_Goer u = allData.get(i);
            if (u.getEmail().equals(valueToSearch))  
                return u;
        }
        return null;
    }

    
    /** 
     * UPDATE an MovieGoer's password in Database file
     * Validate user's input of current password to ensure password is correct before updating it
     * @param email             Email of MovieGoer who password will be updated
     * @param currentPassword   Current password (Unencrypted) of MovieGoer
     * @param newPassword       New password (Unencrypted) of MovieGoer
     *
     */
    public void updatePasswordHashed(String email, String currentPassword, String newPassword) {
        ArrayList<Movie_Goer> allData = read();
        ArrayList<Movie_Goer> returnData = new ArrayList<Movie_Goer>();
        
        for (int i=0; i<allData.size(); i++){
            Movie_Goer u = allData.get(i);
            if (u.getEmail().equals(email))
                u.updatePassword(currentPassword, newPassword);
            returnData.add(u);
        }

        replaceExistingFile(FILENAME, returnData);
    }

    
    /** 
     * UPDATE MovieGoer's with new value based on a given attribute and the current value in Database file
     * @param col       Given attribute to be check for (based on constant as defined)
     * @param oldValue  Attribute with matching value, to be updated
     * @param newValue  New value of MovieGoer's attribute
     */
    public void updateByAttribute(int col, Object oldValue, Object newValue) {
        ArrayList<Movie_Goer> allData = read();
        ArrayList<Movie_Goer> returnData = new ArrayList<Movie_Goer>();
                
        for (int i=0; i<allData.size(); i++){
            Movie_Goer m = allData.get(i);
            switch(col) {
                case NAME:
                    if (m.getName().equals((String) oldValue))
                        m.setName((String) newValue);
                    returnData.add(m);
                    break;
                case MOBILE_NUMBER:
                    if (m.getMobileNumber().equals((String) oldValue))
                        m.setMobileNumber((String) newValue);
                    returnData.add(m);
                    break;
                default:   
                    break;
            }
        }

        replaceExistingFile(FILENAME, returnData);
    }

    
    /** 
     * Delete an MovieGoer in the Database file, based on the email attribute passed
     * @param email Email of MovieGoer who will be deleted
     */
    public void deleteByEmail(String email) {
        ArrayList<Movie_Goer> allData = read();
        ArrayList<Movie_Goer> returnData = new ArrayList<Movie_Goer>();
        
        for (int i=0; i<allData.size(); i++){
            Movie_Goer u = allData.get(i);
            if (!u.getEmail().equals(email))
                returnData.add(u);        
        }

        replaceExistingFile(FILENAME, returnData);
    }

    
    /** 
     * Overwrite Database file with new data of list of Admin
     * @param filename      Filename to check for
     * @param returnData    New ArrayList of MovieGoer to be written to the file
     */
    public void replaceExistingFile(String filename, ArrayList<Movie_Goer> returnData) {
        File tempFile = new File(filename);
        if (tempFile.exists())
            tempFile.delete();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(returnData);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}