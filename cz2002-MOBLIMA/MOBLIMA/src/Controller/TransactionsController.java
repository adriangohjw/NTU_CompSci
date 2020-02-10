package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import BusinessLayer.TransactionsLayer;

import Model.*;

public class TransactionsController {

    /**
     * The file name of the database file that this controller will access
     */
    public final static String FILENAME = "MOBLIMA/database/transactions.txt";

    
    /** 
     * CREATE a new Transaction and add it into the database file
     * Attributes are validated before creation
     * If attributes are not allowed, throw error and do nothing
     * If Database file exist, existing records are read and new Transaction object is aopended before saving
     * If Database file does not exist, Transaction object will be written to a new file and saved
     * @param cinemaCode        This Transaction's cinema code
     * @param name              Name of MovieGoer of This Transaction
     * @param email             Email of MovieGoer of This Transactins
     * @param mobileNumber      Mobile number of MovieGoer of This Transaction
     * @param movie             Movie of This Transaction
     */
    public void create(String cinemaCode, String name, String email, String mobileNumber, Movie movie) {
        if (TransactionsLayer.isTransactionValid(cinemaCode, name, email, mobileNumber, movie)) {
            ArrayList<Transaction> allData = new ArrayList<Transaction>();
            File tempFile = new File(FILENAME);
            if (tempFile.exists())
                allData = read();
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
                allData.add(new Transaction(cinemaCode, name, email, mobileNumber, movie));
                out.writeObject(allData);
                out.flush();
                out.close();
            } catch (IOException e) {
                // ignore error
            }
        }
        else {
            // do nothing
        }
    }

    
    /** 
     * READ and return every Cineplex in the Database file
     * If Database file not found, ignore error and return empty list
     * @return Model.@{@link Transaction}  Return list of Transaction if any, else empty list
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Transaction> read() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));
            ArrayList<Transaction> allData = (ArrayList<Transaction>) ois.readObject();
            ois.close();
            return allData;
        } catch (ClassNotFoundException | IOException e) {
            // ignore error
        }
        return new ArrayList<Transaction>();
    }

    
    /** 
     * READ and return every Transaction of a given TID in the Database file
     * @param TID                           Transaction ID of Transaction to search for
     * @return Model.@{@link Transaction}   Return list of Transaction if found, else empty list
     */
    public ArrayList<Transaction> readByTID(String TID) {
        ArrayList<Transaction> allData = read();
        Transaction transaction = null;
        ArrayList<Transaction> returnData = new ArrayList<Transaction>();

        for (int i=0; i<allData.size(); i++) {
            transaction = allData.get(i);
            if (transaction.getTID().equals(TID))
                returnData.add(transaction);
        }
        return returnData;
    }

    
    /** 
     * READ and return every Transaction of a given MovieGoer's username in the Database file
     * @param movieGoerUsername             MovieGoer's username of Transaction to search for
     * @return Model.@{@link Transaction}   Return list of Transaction if found, else empty list
     */
    public ArrayList<Transaction> readByMovieGoerUsername(String movieGoerUsername) {
        ArrayList<Transaction> allData = read();
        Transaction transaction = null;
        String dbUsername = null;
        ArrayList<Transaction> returnData = new ArrayList<Transaction>();

        for (int i=0; i<allData.size(); i++){
            transaction = allData.get(i);
            dbUsername = transaction.getEmail();
            if (dbUsername.equals(movieGoerUsername))
                returnData.add(transaction); 
        }
        return returnData;
    }

    
    /** 
     * Delete a Transaction in the Database file, based on the TID and MovieGoer's username attribute passed
     * @param TID           Transaction ID of Transaction which will be deleted
     * @param username      Username of Transaction which will be deleted
     */
    public void delete(String TID, String username) {
        ArrayList<Transaction> allData = read();
        Transaction transaction = null;
        ArrayList<Transaction> returnData = new ArrayList<Transaction>();

        for (int i=0; i<allData.size(); i++){
            transaction = allData.get(i);
            if (transaction.getTID().equals(TID) 
                    && transaction.getEmail().equals(username))
                continue;
            returnData.add(transaction);                
        }
        replaceExistingFile(FILENAME, returnData);
    }

    
    /** 
     * Overwrite Database file with new data of list of Admin
     * @param filename      Filename to check for
     * @param returnData    New ArrayList of Transaction to be written to the file
     */
    public void replaceExistingFile(String filename, ArrayList<Transaction> returnData) {
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