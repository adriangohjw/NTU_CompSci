/*package Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Controller.CineplexesController;
import Controller.MoviesController;
import Controller.SessionsController;

import static Controller.SessionsController.MOVIE;
import static Controller.SessionsController.SESSION_DATETIME;
import static Controller.SessionsController.SEATS_AVAILABILITY;

import Model.*;

public class SessionsControllerTest {
    public static void main(String[] args) throws ClassNotFoundException, IOException {

        MoviesController moviesCtrl = new MoviesController();
        new File(moviesCtrl.FILENAME).delete();

        CineplexesController cineplexesCtrl = new CineplexesController();
        new File(cineplexesCtrl.FILENAME).delete();

        SessionsController sessionsCtrl = new SessionsController();

        // creating test values + testing SessionsController.create()

            // creating seatingPlan template
            SeatingPlan seatingPlan1 = new SeatingPlan(10,10);
            SeatingPlan seatingPlan2 = new SeatingPlan(20,20);

            // creating movie template
            String currentDate = new SimpleDateFormat("YYYY-MM-dd").format(new Date());

            ArrayList<String> listCast =  new ArrayList<String>();
            listCast.add("A_cast1");
            //moviesCtrl.create("A", MovieType.BLOCKBUSTER, "A_synopsis", "NC16", currentDate, "2020-01-01", "A_director", listCast);

            listCast.clear();
            listCast.add("B_cast1");
            //moviesCtrl.create("B", MovieType.BLOCKBUSTER, "B_synopsis", "NC16", currentDate, "2020-01-01", "B_director", listCast);

            listCast.clear();
            listCast.add("C_cast1");
            //moviesCtrl.create("C", MovieType.BLOCKBUSTER, "C_synopsis", "NC16", currentDate, "2020-01-01", "C_director", listCast);

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

            // compare DB before and after creating sessions
            System.out.println(".....Testing SessionsController.create() - Before");
            readAllAndPrintCinema(sessionsCtrl.getCinemasController().read());

            System.out.println(".....Testing SessionsController.create() - After");
            sessionsCtrl.create("AAA", moviesCtrl.readByID(0), "2030-01-01 06:00");
            sessionsCtrl.create("AAA", moviesCtrl.readByID(0), "2030-01-01 12:00");
            readAllAndPrintCinema(sessionsCtrl.getCinemasController().read());

        // testing SessionsController.read()

            System.out.println(".....Testing SessionsController.read()");
            readAllAndPrintSession(sessionsCtrl.read());

        // testing SessionsController.readByAttributes()

            System.out.println(".....Testing SessionsController.readByAttributes()");
            readAllAndPrintSession(sessionsCtrl.readByAttributes(SESSION_DATETIME, "2030-01-01 06:00"));

        // testing SessionsController.updateByAttribute()

            System.out.println(".....Testing SessionsController.updateByAttributes()");
            sessionsCtrl.updateByAttribute(SESSION_DATETIME, "AAA", "2030-01-01 12:00", "2030-12-12 12:12");
            readAllAndPrintSession(sessionsCtrl.read());

        // testing SessionsController.delete()

            System.out.println(".....Testing SessionsController.delete()");
            sessionsCtrl.delete("AAA", "2030-01-01 06:00");
            readAllAndPrintSession(sessionsCtrl.read());
    }

    public static void readAllAndPrintSession(ArrayList<Session> sessionsListing){     
        sessionsListing.forEach(n->System.out.println(n));
    }
    
    public static void readAllAndPrintCinema(ArrayList<Cinema> cinemasListing){     
        cinemasListing.forEach(n->System.out.println(n));
    }
}*/