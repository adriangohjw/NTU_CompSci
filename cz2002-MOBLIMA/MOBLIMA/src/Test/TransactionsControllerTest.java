/*package Test;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import Controller.*;
import static Controller.TransactionsController.FILENAME;

import Model.*;

public class TransactionsControllerTest {

    public static void main(String[] args) throws Exception {

        new File(FILENAME).delete();

        TransactionsController transactionsController = new TransactionsController();
        ArrayList<Transaction> transactionListing = new ArrayList<Transaction>();

        // creating test values
        Movie_Goer movieGoer1 = new Movie_Goer("adrian1@gmail.com", "myUnhashedPassword");
        movieGoer1.setName("adrian goh #1");
        movieGoer1.setMobileNumber("11111111");
        Movie_Goer movieGoer2 = new Movie_Goer("adrian2@gmail.com", "myUnhashedPassword");
        movieGoer2.setName("adrian goh #2");
        movieGoer2.setMobileNumber("22222222");

        //Transaction transaction1 = new Transaction("AAA", movieGoer1);
       // Transaction transaction2 = new Transaction("BBB", movieGoer2);

        //transactionListing.add(transaction1);
        //transactionListing.add(transaction2);

        // Testing TransactionsController.create()
        System.out.println(".....Testing TransactionsController.create()");
        transactionListing.forEach(transaction->transactionsController.create(transaction));
        readAllAndPrint(transactionsController.read());

        // testing TransactionsController.read()
        System.out.println(".....Testing TransactionsController.read()");
        readAllAndPrint(transactionsController.read());

        // testing TransactionsController.readByTID()
        System.out.println(".....Testing TransactionsController.readByTID()");
        readAllAndPrint(transactionsController.readByTID(transaction1.getTID()));

        // testing TransactionsController.readByMovieGoerUsername()
        System.out.println(".....Testing TransactionsController.readByMovieGoerUsername()");
        readAllAndPrint(transactionsController.readByMovieGoerUsername("adrian1@gmail.com"));

        // testing TransactionsController.delete()
        System.out.println(".....Testing TransactionsController.delete()");
        transactionsController.delete(transaction1.getTID(), "adrian1@gmail.com");
        readAllAndPrint(transactionsController.read());
    }   

    public static void readAllAndPrint(ArrayList<Transaction> transactionListing){     
        transactionListing.forEach(n->System.out.println(n));
    }
}*/