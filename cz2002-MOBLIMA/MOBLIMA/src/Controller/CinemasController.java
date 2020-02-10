package Controller;

import java.util.ArrayList;

import BusinessLayer.CinemasLayer;

import Model.*;

public class CinemasController {

    /**
     * The Cineplex Controller that this controller will reference
     */
    private CineplexesController cineplexesCtrl;

    /**
     * The file name of the database file that this controller will access
     */
    public String FILENAME;

    /**
     * Declaring constant for better readability and easier referencing to attribute
     */
    public final static int CODE = 0;
    public final static int CINEMA_TYPE = 1;
    public final static int SEATING_PLAN = 2;
    public final static int SESSIONS = 3;

    
    /** 
     * Default constructor
     */
    @SuppressWarnings("static-access")
    public CinemasController() {
        this.cineplexesCtrl = new CineplexesController();
        this.FILENAME = cineplexesCtrl.FILENAME;
    }

    
    /** 
     * Parameterized constructor with user-defined Cineplex Controller
     * @param cineplexesCtrl    Non-default Cineplex Controller to be referenced instead
     */
    @SuppressWarnings("static-access")
    public CinemasController(CineplexesController cineplexesCtrl) {
        this.cineplexesCtrl = cineplexesCtrl;
        this.FILENAME = cineplexesCtrl.FILENAME;
    }

    
    /** 
     * Gets the Cineplex Controller that this controller is referencing
     * @return CineplexesController     This controller's Cineplex Controller
     */
    public CineplexesController getCineplexesController(){
        return this.cineplexesCtrl;
    }

    
    /** 
     * Change the Cineplex Controller that this controller is referencing
     * @param cineplexesCtrl    This controller's new Cineplex Controller
     */
    public void setCineplexesController(CineplexesController cineplexesCtrl){
        this.cineplexesCtrl = cineplexesCtrl;
    }

    
    /** 
     * CREATE a new Cinema and add it into the database file
     * Attributes are validated before creation
     * If attributes are not allowed, throw error and do nothing
     * If Database file exist, existing records are read and new Cinema object is aopended before saving
     * If Database file does not exist, Cinema object will be written to a new file and saved
     * @param cineplexName  Name of Cineplex that this Cinema will be added to
     * @param code          This cinema's code
     * @param cinemaType    This cinema's type
     * @param seatingPlan   This cinema's seating plan
     */
    public void create(
            String cineplexName, String code, CinemaType cinemaType, SeatingPlan seatingPlan 
    ) {
        if (CinemasLayer.isCinemaValid(cineplexName, code, cinemaType, seatingPlan)){
            Cinema cinema = new Cinema(code, cinemaType, seatingPlan);
            ArrayList<Cineplex> allData = this.cineplexesCtrl.read();
            ArrayList<Cineplex> returnData = new ArrayList<Cineplex>();
            for (int i=0; i<allData.size(); i++){
                Cineplex cineplex_i = allData.get(i);
                if (cineplex_i.getName().equals(cineplexName)){
                    ArrayList<Cinema> cinemas = cineplex_i.getCinemas();
                    cinemas.add(cinema);
                    cineplex_i.setCinemas(cinemas);
                }
                returnData.add(cineplex_i);
            }
            this.cineplexesCtrl.replaceExistingFile(FILENAME, returnData);
        } else {
            // do nothing
        }
    } 

    
    /** 
     * READ and return every Cinema in the Database file
     * @return Model.{@link Cinema}    Return list of Cinemas if found, else empty list
     */
    public ArrayList<Cinema> read() {
        ArrayList<Cinema> returnData = new ArrayList<Cinema>();
        ArrayList<Cineplex> cineplexListing = this.cineplexesCtrl.read(); 
        Cineplex cineplex = null;

        for (int i=0; i<cineplexListing.size(); i++){
            cineplex = cineplexListing.get(i);
            cineplex.getCinemas().forEach(n->returnData.add(n));
        }
        return returnData;
    }

    
    /** 
     * READ and return every Cinema of a given Cineplex in the Database file
     * @param name                  Name of cineplex to search for
     * @return Model.{@link Cinema}    Return list of Cinemas if found, else empty list
     */
    public ArrayList<Cinema> readByCineplexName(String name){
        ArrayList<Cinema> returnData = new ArrayList<Cinema>();
        ArrayList<Cineplex> cineplexListing = this.cineplexesCtrl.read();
        Cineplex cineplex = null;

        for (int i=0; i<cineplexListing.size(); i++){
            cineplex = cineplexListing.get(i);
            if(cineplex.getName().equals(name)){
                cineplex.getCinemas().forEach(n->returnData.add(n));
            }
        }
        return returnData;
    }

    
    /** 
     * READ and return every Cinema based on a certain value of a given attribute in the Database file
     * @param col                   Given attribute to be check for (based on constant as defined)
     * @param valueToSearch         Value of given attribute to search for
     * @return Model.{@link Cinema}    Return list of Cinemas if any, else empty list
     */
    public ArrayList<Cinema> readByAttribute(int col, Object valueToSearch) {
        ArrayList<Cinema> returnData = new ArrayList<Cinema>();
        ArrayList<Cinema> cinemaListing = read();
        Cinema cinema = null;

        for (int j=0; j<cinemaListing.size(); j++){
            cinema = cinemaListing.get(j);
            switch (col) {
                case CODE:
                    if (cinema.getCode().equals((String) valueToSearch))
                        returnData.add(cinema);
                    break;
                case CINEMA_TYPE:
                    if (cinema.getCinemaType().equals((CinemaType) valueToSearch))
                        returnData.add(cinema);
                    break;
                default:
                    break;
            }
        }
        return returnData;
    }

    
    /** 
     * UPDATE a Cinema's with new value based on a given attribute and cinema code in Database file
     * @param col       Given attribute to be check for (based on constant as defined)
     * @param code      Code of cinema to be updated
     * @param newValue  New value of cinema's attribute 
     */
    @SuppressWarnings("unchecked")
    public void updateByAttribute(int col, String code, Object newValue) {
        ArrayList<Cineplex> allData = this.cineplexesCtrl.read();
        ArrayList<Cineplex> returnData = new ArrayList<Cineplex>();

        for (int i=0; i<allData.size(); i++){
            Cineplex cineplex_i = allData.get(i);
            
            ArrayList<Cinema> cinemas = cineplex_i.getCinemas();
            ArrayList<Cinema> cinemaLiisting = new ArrayList<Cinema>();

            // Check if there's a match for cinema based on cinema's code
            for (int j=0; j<cinemas.size(); j++){
                Cinema cinema_j = cinemas.get(j);
                if (cinema_j.getCode().equals(code)){
                    switch (col) {
                        case CINEMA_TYPE:
                            cinema_j.setCinemaType((CinemaType) newValue);
                            break;
                        case SESSIONS:
                            cinema_j.setSessions((ArrayList<Session>) newValue);
                            break; 
                        default:
                            break;
                    } 
                }
                cinemaLiisting.add(cinema_j);
            }

            cineplex_i.setCinemas(cinemaLiisting);
            returnData.add(cineplex_i);
        }
        this.cineplexesCtrl.replaceExistingFile(FILENAME, returnData);
    }

    
    /** 
     * Delete a Cinema in the Database file, based on the cinema code attribute passed
     * @param code  Code of cinema which will be deleted
     */
    public void delete(String code) {
        ArrayList<Cineplex> allData = this.cineplexesCtrl.read();
        ArrayList<Cineplex> returnData = new ArrayList<Cineplex>();

        for (int i=0; i<allData.size(); i++){
            Cineplex cineplex_i = allData.get(i);

            // ensure cineplex has more than 3 cinemas before allowing deletion
                if (cineplex_i.getCinemas().size() > 3){
                    ArrayList<Cinema> cinemas = cineplex_i.getCinemas();
                    ArrayList<Cinema> newCinemas = new ArrayList<Cinema>();

                    // Check if there's a match for cinema based on cinema's code
                    for (int j=0; j<cinemas.size(); j++){
                        Cinema cinema_j = cinemas.get(j);
                        if (!cinema_j.getCode().equals(code))  // add cinema if code does not match
                            newCinemas.add(cinema_j);
                    }
                    cineplex_i.setCinemas(newCinemas);
                }
            returnData.add(cineplex_i);
        }
        this.cineplexesCtrl.replaceExistingFile(FILENAME, returnData);
    } 
}