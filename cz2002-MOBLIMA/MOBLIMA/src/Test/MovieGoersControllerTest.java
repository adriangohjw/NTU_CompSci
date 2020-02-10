/*package Test;

import java.io.File;
import java.util.ArrayList;

import Controller.*;
import static Controller.MovieGoersController.FILENAME;
import static Controller.MovieGoersController.NAME;
import static Controller.MovieGoersController.MOBILE_NUMBER;

import Model.*;

public class MovieGoersControllerTest {
    public static void main(String[] args) throws Exception {

        new File(FILENAME).delete();
        
        MovieGoersController movieGoersController = new MovieGoersController();
        ArrayList<Movie_Goer> movieGoerListing = new ArrayList<Movie_Goer>();
        Movie_Goer movieGoer = null;

        // creating test values + Testing MovieGoersController.create()
        System.out.println(".....Testing MovieGoersController.create()");
        movieGoersController.create("adrian1@gmail.com", "myUnhashedPassword", "adrian goh #1", "11111111");
        movieGoersController.create("adrian1@gmail.com", "myUnhashedPassword", "adrian goh #1", "11111111");
        readAllAndPrint(movieGoersController.read());

        // testing MovieGoersController.read()
        System.out.println(".....Testing MovieGoersController.read()");
        readAllAndPrint(movieGoersController.read());

        // testing MovieGoersController.readByEmail()
        System.out.println(".....Testing MovieGoersController.readByEmail()");
        movieGoer = movieGoersController.readByEmail("adrian1@gmail.com");
        movieGoerListing.clear();
        movieGoerListing.add(movieGoer);
        readAllAndPrint(movieGoerListing);

        // testing MovieGoersController.updatePasswordHashed()
        System.out.println(".....Testing MovieGoersController.updatePasswordHashed()");
        movieGoersController.updatePasswordHashed("adrian1@gmail.com", "myUnhashedPassword", "myUnhashedPassword2");
        readAllAndPrint(movieGoersController.read());

        // testing MovieGoersController.updateByAttribute()
        System.out.println(".....Testing MovieGoersController.updateByAttribute() - Name");
        movieGoersController.updateByAttribute(NAME, "adrian goh #1", "adrian goh #100");
        readAllAndPrint(movieGoersController.read());
        System.out.println(".....Testing MovieGoersController.updateByAttribute() - Mobile Number");
        movieGoersController.updateByAttribute(MOBILE_NUMBER, "11111111", "00000000");
        readAllAndPrint(movieGoersController.read());

        // testing MovieGoersController.deleteByEmail()
        System.out.println(".....Testing MovieGoersController.deleteByEmail()");
        movieGoersController.deleteByEmail("adrian2@gmail.com");
        readAllAndPrint(movieGoersController.read());
    }

    public static void readAllAndPrint(ArrayList<Movie_Goer> movieGoerListing){     
        movieGoerListing.forEach(n->System.out.println(n));
    }
}*/