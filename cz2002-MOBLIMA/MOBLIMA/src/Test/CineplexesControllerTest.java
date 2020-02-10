/*package Test;

import java.io.File;
import java.util.ArrayList;

import Controller.*;
import static Controller.CineplexesController.FILENAME;

import Model.*;

public class CineplexesControllerTest {
    public static void main(String[] args) throws Exception {

        new File(FILENAME).delete();
        
        CineplexesController cineplexesCtrl = new CineplexesController();
        Cineplex cineplex = null;

        // creating test values

        // Testing CineplexesController.create()
        System.out.println(".....Testing CineplexesController.create()");

        SeatingPlan seatingPlan1 = new SeatingPlan(10,10);
        SeatingPlan seatingPlan2 = new SeatingPlan(20,20);

        Cinema cinema1 = new Cinema("AAA", CinemaType.PREMIUM, seatingPlan1);
        Cinema cinema2 = new Cinema("BBB", CinemaType.STANDARD, seatingPlan1);
        Cinema cinema3 = new Cinema("CCC", CinemaType.STANDARD, seatingPlan2);
        ArrayList<Cinema> cinemaList1 = new ArrayList<Cinema>(){
            {
                add(cinema1);
                add(cinema2);
                add(cinema3);
            }
        };
        cineplexesCtrl.create("Cineplex 1", cinemaList1);

        Cinema cinema4 = new Cinema("DDD", CinemaType.PREMIUM, seatingPlan1);
        Cinema cinema5 = new Cinema("EEE", CinemaType.STANDARD, seatingPlan2);
        ArrayList<Cinema> cinemaList2 = new ArrayList<Cinema>(){
            {
                add(cinema4);
                add(cinema5);
            }
        };
        cineplexesCtrl.create("Cineplex 2", cinemaList2);
        readAllAndPrint(cineplexesCtrl.read());
        
        // testing CineplexesController.read()
        System.out.println(".....Testing CineplexesController.read()");
        readAllAndPrint(cineplexesCtrl.read());

        // testing CineplexesController.readByName()
        System.out.println(".....Testing CineplexesController.readByName()");
        cineplex = cineplexesCtrl.readByName("Cineplex 1");
        System.out.println(cineplex);

        // testing CineplexesController.updateByName()
        System.out.println(".....Testing CineplexesController.updateByName()");
        cineplexesCtrl.updateByName("Cineplex 1", "Cineplex 1 New");
        readAllAndPrint(cineplexesCtrl.read());

        // testing MoviesController.deleteByName()
        System.out.println(".....Testing CineplexesController.deleteByName()");
        cineplexesCtrl.deleteByName("Cineplex 1 New");
        readAllAndPrint(cineplexesCtrl.read());
    }

    public static void readAllAndPrint(ArrayList<Cineplex> cineplexListing){     
        cineplexListing.forEach(n->System.out.println(n));
    }
}*/