package Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import BusinessLayer.SessionsLayer;

import static Controller.CinemasController.SESSIONS;
import static Controller.CinemasController.CODE;

import Model.*;

public class SessionsController {

    /**
     * The Cineplex Controller that this controller will reference
     */
    private CinemasController cinemasCtrl = new CinemasController();

    /**
     * The file name of the database file that this controller will access
     */
    public String FILENAME;
    
    /**
     * Declaring constant for better readability and easier referencing to attribute
     */
    public final static int MOVIE = 0;
    public final static int SESSION_DATETIME = 1;
    public final static int SEATS_AVAILABILITY = 2;
    public final static int ID = 3;

    
    /** 
     * Default constructor
     */
    public SessionsController(){
        this.cinemasCtrl = new CinemasController();
        this.FILENAME = cinemasCtrl.FILENAME;
    }

    
    /** 
     * Parameterized constructor with user-defined Cinema Controller
     * @param cinemasCtrl    Non-default Cinema Controller to be referenced instead
     */
    public SessionsController(CinemasController cinemasCtrl){
        this.cinemasCtrl = cinemasCtrl;
        this.FILENAME = cinemasCtrl.FILENAME;
    }

    /** 
     * Gets the Cinema Controller that this controller is referencing
     * @return CinemasController     This controller's Cinema Controller
     */
    public CinemasController getCinemasController(){
        return this.cinemasCtrl;
    }

    /** 
     * Change the Cinema Controller that this controller is referencing
     * @param cinemasCtrl   This controller's Cinema Controller
     */
    public void setCinemasController(CinemasController cinemasCtrl) {
        this.cinemasCtrl = cinemasCtrl;
    }
    
    /** 
     * CREATE a new Session and add it into the database file
     * Attributes are validated before creation
     * If attributes are not allowed, throw error and do nothing
     * If Database file exist, existing records are read and new Session object is aopended before saving
     * If Database file does not exist, Session object will be written to a new file and saved
     * @param cinemaCode        This Sessions's cinema code
     * @param movie             This Sessions's movie
     * @param sessionDateTime   This Sessions's date and time
     */
    public void create(String cinemaCode, Movie movie, LocalDateTime sessionDateTime) {
        if (SessionsLayer.isSessionValid(cinemaCode, movie, sessionDateTime)) {
            SeatingPlan seatingPlan = cinemasCtrl.readByAttribute(CODE, cinemaCode).get(0).getSeatingPlan();
            Session session = new Session(movie, sessionDateTime, seatingPlan, getLastId()+1);
            ArrayList<Cinema> allData  = this.cinemasCtrl.read();
            ArrayList<Session> sessions = new ArrayList<Session>();
            for (int i=0; i<allData.size(); i++){
                Cinema cinema_i = allData.get(i);
                if (cinema_i.getCode().equals(cinemaCode)){
                    sessions = cinema_i.getSessions();
                    sessions.add(session);
                    cinema_i.setSessions(sessions);
                    this.cinemasCtrl.updateByAttribute(SESSIONS, cinemaCode, sessions);
                    sessions.clear();
                    break;
                }
            }
        } else {
            // do nothing
        }
    }

    
    /** 
     * READ and return every Cinema in the Database file
     * @return Model.{@link Session}   Return list of Sessions if found, else empty list
     */
    public ArrayList<Session> read() {
        ArrayList<Cinema> allCinemas  = this.cinemasCtrl.read();
        ArrayList<Session> allSessions = new ArrayList<Session>();
        Cinema c = null;
        for (int i=0; i<allCinemas.size(); i++) {
            c = allCinemas.get(i);
            c.getSessions().forEach(n->allSessions.add(n));
        }
        return allSessions;
    }; 

    
    /** 
     * READ and return every Session based on a certain value of a given attribute in the Database file
     * @param col                       Given attribute to be check for (based on constant as defined)
     * @param valueToSearch             Value of given attribute to search for
     * @return Model.{@link Session}    Return list of Sessions if any, else empty list
     */
    public ArrayList<Session> readByAttributes(int col, Object valueToSearch) {
        ArrayList<Session> allData = read();
        ArrayList<Session> returnData = new ArrayList<Session>();
        Session s = null;
        
        for (int i=0; i<allData.size(); i++){
            s = allData.get(i);
            switch(col){
                case MOVIE:  // Movies going to be compared by movie ID
                    if (s.getMovie().getId() == (int) valueToSearch)
                        returnData.add(s);
                        break;
                case SESSION_DATETIME:
                    if (s.getSessionDateTime().equals((LocalDateTime) valueToSearch))
                        returnData.add(s);
                        break;
                default:
                    break;
            }           
        }
        return returnData;
    }; 

    
    /** 
     * READ and return every Session of a cinema on a speficic date in the Database file
     * @param cinemaCode                Cinema's code to be check for
     * @param sessionDate               Value of date to search for
     * @return Model.{@link Session}    Return list of Sessions if any, else empty list
     */
    @SuppressWarnings("static-access")
    public ArrayList<Session> readByAttributes(String cinemaCode, LocalDate sessionDate) {
        ArrayList<Cinema> cinemas = this.cinemasCtrl.readByAttribute(cinemasCtrl.CODE, cinemaCode);
        if (cinemas.isEmpty()) {
            return null;
        } else {
            ArrayList<Session> allDate = cinemas.get(0).getSessions();
            ArrayList<Session> returnData = new ArrayList<Session>();
            Session s = null;
            for (int i=0; i<allDate.size(); i++) {
                s = allDate.get(i);
                if (s.getSessionDateTime().toLocalDate().equals(sessionDate))
                    returnData.add(s);
            }
            return returnData;
        }        
    }

    
    /** 
     * READ and return a session of a given cinema on a specific date and time in the Database file
     * @param cinemaCode        Cinema's code to be check for
     * @param sessionDateTime   Value of date and time to search for
     * @return Session          Return Session if found, else null object
     */
    @SuppressWarnings("static-access")
    public Session readBySession(String cinemaCode, LocalDateTime sessionDateTime) {
        ArrayList<Cinema> cinemas = this.cinemasCtrl.readByAttribute(cinemasCtrl.CODE, cinemaCode);
        Cinema c = null;
        if(cinemas.isEmpty())
            return null;
        else{
            c = cinemas.get(0);
        }

        ArrayList<Session> allData = c.getSessions();
        Session s = null;

        for (int i=0; i<allData.size(); i++){
            s = allData.get(i);
            if (s.getSessionDateTime().equals(sessionDateTime))
                return s;
        }
        return null;
    }; 

    
    /** 
     * READ and return a session of a given session ID in the Database file
     * @param id            Session's ID to check for
     * @return Session      Return Session if found, else null object
     */
    public Session readById(int id) {
        ArrayList<Session> allData = read();
        Session s = null;

        for (int i=0; i<allData.size(); i++){
            s = allData.get(i);
            if (s.getId() == id)
                return s;
        }
        return s;
    }; 

    
    /** 
     * UPDATE a Session's with new value based on a given attribute and cinema code in Database file
     * @param col           Given attribute to be check for (based on constant as defined)
     * @param cinemaCode    Code of cinema to be updated
     * @param oldValue      Value of given attribute to search for
     * @param newValue      New value of session's attribute 
     */
    @SuppressWarnings("static-access")
    public void updateByAttribute(int col, String cinemaCode, Object oldValue, Object newValue) {
        ArrayList<Cinema> allCinemas  = this.cinemasCtrl.read();
        ArrayList<Session> allSessions = new ArrayList<Session>();
        ArrayList<Session> returnSessions = new ArrayList<Session>();

        // loop through all cinemas to find one with matching cinema code
        for (int i=0; i<allCinemas.size(); i++) {
            Cinema cinema_i = allCinemas.get(i);
            if (cinema_i.getCode().equals(cinemaCode)){
                
                // loop through all sessions of the matched cinema and update if necessary
                allSessions = cinema_i.getSessions();
                returnSessions.clear();  // ensure it started without existing session
                
                for (int j=0; j<allSessions.size(); j++){
                    Session s = allSessions.get(j);

                    switch(col) {
                
                        case MOVIE:  // Movies going to be compared by movie ID
                            if (s.getMovie().getId() == (int) oldValue) {
                                if (SessionsLayer.isSessionValid(cinemaCode, (Movie) newValue, s.getSessionDateTime()))
                                    s.setMovie((Movie) newValue);
                            }
                            break;

                        case SESSION_DATETIME:
                            if (s.getSessionDateTime().equals((LocalDateTime) oldValue)) {
                                if (SessionsLayer.isSessionValid(cinemaCode, s.getMovie(), (LocalDateTime) newValue)) 
                                    s.setSessionDateTime((LocalDateTime) newValue);
                            }
                            break;

                        case ID:
                            if (s.getId() == (int) oldValue)
                                s.setId((int) newValue);
                            break;

                        default:
                            break;

                    }
                    returnSessions.add(s);
                }

                // update DB and break (stop searching other cinema if already found one with matching code)
                this.cinemasCtrl.updateByAttribute(cinemasCtrl.SESSIONS, cinemaCode, returnSessions);
                break; 
            }
        }
    } 

    
    /** 
     * UPDATE a Session of a given session ID based on given attribute in Database file 
     * @param col           Given attribute to be check for (based on constant as defined)
     * @param id            Session's ID to check for
     * @param newValue      New value of session's attribute 
     */
    @SuppressWarnings("static-access")
    public void updateById(int col, int id, Object newValue) {
        ArrayList<Cinema> allCinemas  = this.cinemasCtrl.read();
        ArrayList<Session> allSessions = new ArrayList<Session>();
        ArrayList<Session> returnSessions = new ArrayList<Session>();
        Session s = null;

        for (int i=0; i<allCinemas.size(); i++) {
            Cinema cinema_i = allCinemas.get(i);
            allSessions = cinema_i.getSessions();
            returnSessions.clear();// ensure it started without existing session

            for (int j=0; j<allSessions.size(); j++){
                s = allSessions.get(j);
                if (s.getId() == id)

                    switch (col){

                        case MOVIE:
                            if (SessionsLayer.isSessionValid(cinema_i.getCode(), (Movie) newValue, s.getSessionDateTime())) 
                                s.setMovie((Movie) newValue);
                            break;

                        case SESSION_DATETIME:
                            if (SessionsLayer.isSessionValid(cinema_i.getCode(), s.getMovie(), (LocalDateTime) newValue))
                                s.setSessionDateTime((LocalDateTime) newValue);
                            break;

                        case SEATS_AVAILABILITY:
                            s.setSeatsAvailability((SeatingPlan) newValue);
                            break;

                        default:
                            break;

                    }
                returnSessions.add(s);
            }

            // update DB and break (stop searching other cinema if already found one with matching code)
            this.cinemasCtrl.updateByAttribute(cinemasCtrl.SESSIONS, cinema_i.getCode(), returnSessions);
        }
    }

    
    /** 
     * UPDATE a Session's seats availability of a given session ID in Database file 
     * @param id                    Session's ID to check for
     * @param newSeatsAvailabiity   New value of session's seats availability 
     */
    @SuppressWarnings("static-access")
    public void updateSeatsAvailability(int id, SeatingPlan newSeatsAvailabiity) {
        ArrayList<Cinema> allCinemas  = this.cinemasCtrl.read();
        ArrayList<Session> allSessions = new ArrayList<Session>();
        ArrayList<Session> returnSessions = new ArrayList<Session>();
        Session s = null;

        for (int i=0; i<allCinemas.size(); i++) {
            Cinema cinema_i = allCinemas.get(i);
            allSessions = cinema_i.getSessions();
            returnSessions.clear();  // ensure it started without existing session
            for (int j=0; j<allSessions.size(); j++){
                s = allSessions.get(j);
                if (s.getId() == id){
                    s.setSeatsAvailability(newSeatsAvailabiity);
                }
                returnSessions.add(s);
            }

            // update DB and break (stop searching other cinema if already found one with matching code)
            this.cinemasCtrl.updateByAttribute(cinemasCtrl.SESSIONS, cinema_i.getCode(), returnSessions);
        }
    } 

    /**
     * UPDATE a Movie's attribute in Session with matching movieID Database file 
     * @param col           Attribute of movie to update
     * @param movieID       ID of Movie to search for  
     * @param newValue      New value of Movie's attribute
     */
    @SuppressWarnings({"static-access", "unchecked"})
    public void updateByMovie(int col, int movieID, Object newValue) {
        ArrayList<Cinema> allCinemas  = this.cinemasCtrl.read();
        ArrayList<Session> allSessions = new ArrayList<Session>();
        ArrayList<Session> returnSessions = new ArrayList<Session>();
        Session s = null;

        for (int i=0; i<allCinemas.size(); i++) {
            Cinema cinema_i = allCinemas.get(i);
            allSessions = cinema_i.getSessions();
            returnSessions.clear();  // ensure it started without existing session
            for (int j=0; j<allSessions.size(); j++){
                s = allSessions.get(j);
                if (s.getMovie().getId() == movieID){
                    
                    switch (col){

                        case (MoviesController.ID):
                            s.getMovie().setId((int) newValue);
                            break;

                        case (MoviesController.TITLE):
                            s.getMovie().setTitle((String) newValue);
                            break;

                        case (MoviesController.TYPE):
                            s.getMovie().setType((MovieType) newValue);
                            break;

                        case (MoviesController.SYNOPSIS):
                            s.getMovie().setSynopsis((String) newValue);
                            break;

                        case (MoviesController.RATING):
                            s.getMovie().setRating((String) newValue);
                            break;

                        case (MoviesController.DURATION):
                            s.getMovie().setDuration((double) newValue);
                            break;
                            
                        case (MoviesController.MOVIE_RELEASE_DATE):
                            s.getMovie().setMovieReleaseDate((LocalDate) newValue);
                            break;

                        case (MoviesController.MOVIE_END_DATE):
                            s.getMovie().setMovieEndDate((LocalDate) newValue);
                            break;

                        case (MoviesController.DIRECTOR):
                            s.getMovie().setDirector((String) newValue);
                            break;

                        case (MoviesController.CAST):
                            s.getMovie().setCast((ArrayList<String>) newValue);
                            break;

                        case (MoviesController.REVIEWS):
                            s.getMovie().setReviews((ArrayList<Review>) newValue);
                            break;

                        default:
                            break;
                    }
                }
                returnSessions.add(s);
            }

            // update DB and break (stop searching other cinema if already found one with matching code)
            this.cinemasCtrl.updateByAttribute(cinemasCtrl.SESSIONS, cinema_i.getCode(), returnSessions);
        }
    }

    /** 
     * Delete a Session in the Database file, based on the cinema code and datetime attribute passed
     * @param cinemaCode        Code of cinema which will be deleted
     * @param sessionDateTime   Date and time of session which will be deleted
     */
    @SuppressWarnings("static-access")
    public void delete(String cinemaCode, LocalDateTime sessionDateTime){
        ArrayList<Cinema> allCinemas  = this.cinemasCtrl.read();
        ArrayList<Session> allSessions = new ArrayList<Session>();
        ArrayList<Session> returnSessions = new ArrayList<Session>();

        // loop through all cinemas to find one with matching cinema code
        for (int i=0; i<allCinemas.size(); i++) {
            Cinema cinema_i = allCinemas.get(i);
            if (cinema_i.getCode().equals(cinemaCode)){

                // loop through all sessions of the matched cinema and update if necessary
                allSessions = cinema_i.getSessions();
                returnSessions.clear();  // ensure it started without existing session
                for (int j=0; j<allSessions.size(); j++){
                    Session s = allSessions.get(j);
                    if (!(s.getSessionDateTime().equals(sessionDateTime)))
                        returnSessions.add(s);
                }

                // update DB and break (stop searching other cinema if already found one with matching code)
                this.cinemasCtrl.updateByAttribute(cinemasCtrl.SESSIONS, cinemaCode, returnSessions);
                break;
             }
        }
    }

    
    /** 
     * Delete a Session in the Database file, based on the session ID
     * @param id    ID of session which will be deleted
     */
    @SuppressWarnings("static-access")
    public void delete(int id){
        ArrayList<Cinema> allCinemas  = this.cinemasCtrl.read();
        ArrayList<Session> allSessions = new ArrayList<Session>();
        ArrayList<Session> returnSessions = new ArrayList<Session>();

        for (int i=0; i<allCinemas.size(); i++) {
            Cinema cinema_i = allCinemas.get(i);
            allSessions = cinema_i.getSessions();
            returnSessions.clear();  // ensure it started without existing session
            for (int j=0; j<allSessions.size(); j++){
                Session s = allSessions.get(j);
                if (!(s.getId() == id))
                    returnSessions.add(s);
            }
            this.cinemasCtrl.updateByAttribute(cinemasCtrl.SESSIONS, cinema_i.getCode(), returnSessions);
        }
    }

    
    /** 
     * Delete Sessions in the Database file with a specific MovieID
     * @param movieID   Sessions with this MovieID will be deleted
     */
    @SuppressWarnings("static-access")
    public void deleteByMovie(int movieID) {
        ArrayList<Cinema> allCinemas = this.cinemasCtrl.read();
        ArrayList<Session> allSessions = new ArrayList<Session>();
        ArrayList<Session> returnSessions = new ArrayList<Session>();
        Session s = null;

        for (int i=0; i<allCinemas.size(); i++) {
            Cinema cinema_i = allCinemas.get(i);
            allSessions = cinema_i.getSessions();
            returnSessions.clear();  // ensure it started without existing session
            for (int j=0; j<allSessions.size(); j++){
                s = allSessions.get(j);
                if (!(s.getMovie().getId() == movieID))
                    returnSessions.add(s);
            }
            this.cinemasCtrl.updateByAttribute(cinemasCtrl.SESSIONS, cinema_i.getCode(), returnSessions);
        }
    }


    /** 
     * Return the ID of the last Movie in the Database field
     * @return int      ID of last Movie in the Database
     */
    public int getLastId(){
        int lastId = -1;
        int sessionId;
        ArrayList<Session> allData = read();
        for (int i=0; i<allData.size(); i++){
            sessionId = allData.get(i).getId();
            if (sessionId > lastId)
                lastId = sessionId;
        }
        return lastId;
    }

    
    /** 
     * Mark a seat of a session as occupied, based on the seat id and session ID
     * @param seatingPlan   Seating Plan of the session
     * @param seatId        Seat ID to be marked as occupied
     * @param sessionId     Session ID in which the seat will be marked occupied
     * @return boolean      Return true if seat has been marked occupied
     *                      Return false if seat was already marked occupied prior to this
     */
    public boolean assignSeat(SeatingPlan seatingPlan, int seatId, int sessionId){
        if(!seatingPlan.checkSeats(seatId)){
            seatingPlan.assignSeats(seatId);
            this.updateSeatsAvailability(sessionId, seatingPlan);
            return true;
        }
        else{
            System.out.println("Seat already taken!");
            return false;
        }
    }
}
