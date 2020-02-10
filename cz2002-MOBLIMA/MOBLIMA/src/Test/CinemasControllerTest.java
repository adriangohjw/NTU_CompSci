/*package Test;

import java.io.File;
import java.util.ArrayList;

import Controller.CineplexesController;
import Controller.CinemasController;

import static Controller.CinemasController.CODE;
import static Controller.CinemasController.CINEMA_TYPE;

import Model.*;

public class CinemasControllerTest {
    public static void main(String[] args) {

        CineplexesController cineplexesCtrl = new CineplexesController();
        new File(cineplexesCtrl.FILENAME).delete();
        CinemasController cinemasCtrl = new CinemasController();

        // creating test values + testing CinemasController.create()

            // creating seatingPlan template
            SeatingPlan seatingPlan1 = new SeatingPlan(10,10);
            SeatingPlan seatingPlan2 = new SeatingPlan(20,20);

            // added cineplex 1
            Cinema cinema1 = new Cinema("AAA", CinemaType.PREMIUM, seatingPlan1);
            ArrayList<Cinema> cinemaList1 = new ArrayList<Cinema>(){
                {
                    add(cinema1);
                }
            };
            cineplexesCtrl.create("Cineplex 1", cinemaList1);

            // added cineplex 2
            Cinema cinema2 = new Cinema("BBB", CinemaType.PREMIUM, seatingPlan1);
            Cinema cinema3 = new Cinema("CCC", CinemaType.STANDARD, seatingPlan2);
            Cinema cinema4 = new Cinema("DDD", CinemaType.STANDARD, seatingPlan2);
            ArrayList<Cinema> cinemaList2 = new ArrayList<Cinema>(){
                {
                    add(cinema2);
                    add(cinema3);
                    add(cinema4);
                }
            };
            cineplexesCtrl.create("Cineplex 2", cinemaList2);

            // compare DB before and after creating cinemas
            System.out.println(".....Testing CinemasController.create() - Before");
            readAllAndPrintCineplex(cineplexesCtrl.read());

            System.out.println(".....Testing CinemasController.create() - After");
            cinemasCtrl.create("Cineplex 2", "EEE", CinemaType.PREMIUM, seatingPlan2);        
            readAllAndPrintCineplex(cineplexesCtrl.read());
        
        // testing CinemasController.read()

            System.out.println(".....Testing CinemasController.read()");
            readAllAndPrintCinema(cinemasCtrl.read());

        // testing CinemasController.readByAttribute()

            System.out.println(".....Testing CinemasController.readByAttribute() - Code");
            readAllAndPrintCinema(cinemasCtrl.readByAttribute(CODE, "AAA"));

            System.out.println(".....Testing CinemasController.readByAttribute() - Type");
            readAllAndPrintCinema(cinemasCtrl.readByAttribute(CINEMA_TYPE, CinemaType.PREMIUM));

        // testing CinemasController.updateByAttribute()

            System.out.println(".....Testing CinemasController.updateByAttribute() - Type");
            cinemasCtrl.updateByAttribute(CINEMA_TYPE, "AAA", CinemaType.STANDARD);
            readAllAndPrintCinema(cinemasCtrl.read());

        // testing CinemasController.delete()

            System.out.println(".....Testing CinemasController.delete() - Before");
            readAllAndPrintCineplex(cineplexesCtrl.read());
            cinemasCtrl.delete("BBB");
            System.out.println(".....Testing CinemasController.delete() - After");
            readAllAndPrintCineplex(cineplexesCtrl.read());
    }

    public static void readAllAndPrintCineplex(ArrayList<Cineplex> cineplexesListing){     
        cineplexesListing.forEach(n->System.out.println(n));
    }
    
    public static void readAllAndPrintCinema(ArrayList<Cinema> cinemasListing){     
        cinemasListing.forEach(n->System.out.println(n));
    }
}*/