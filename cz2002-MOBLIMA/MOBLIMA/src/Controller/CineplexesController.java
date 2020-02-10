package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import BusinessLayer.CineplexesLayer;

import Model.*;

public class CineplexesController {

    /**
     * File name of Database file to access
     */
    public final static String FILENAME = "MOBLIMA/database/cineplexes.txt";

    /**
     * Declaring constant for better readability and easier referencing to attribute
     */
    public final static int NAME = 0;
    public final static int CINEMAS = 1;

    
    /** 
     * CREATE a new Cineplex and add it into the database file
     * Attributes are validated before creation
     * If attributes are not allowed, throw error and do nothing
     * If Database file exist, existing records are read and new Cineplex object is aopended before saving
     * If Database file does not exist, Cineplex object will be written to a new file and saved
     * @param name      This cineplex's name
     * @param cinemas   This cineplex's list of cinemas
     */
    public void create(String name, ArrayList<Cinema> cinemas) {
        if (CineplexesLayer.isCineplexValid(name, cinemas)) {
            Cineplex cineplex = new Cineplex(name, cinemas);
            ArrayList<Cineplex> allData = new ArrayList<Cineplex>();
            File tempFile = new File(FILENAME);
            if (tempFile.exists()) 
                allData = read();
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME));
                allData.add(cineplex);
                out.writeObject(allData);
                out.flush();
                out.close();
            } catch (IOException e) {
                // ignore error
            }
        } else {
            // do nothing
        }
    }

    
    /**
     * READ and return every Cineplex in the Database file
     * If Database file not found, ignore error and return empty list
     * @return Model.{@link Cineplex}  Return list of Cineplexes if any, else empty list
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Cineplex> read(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME));   
            ArrayList<Cineplex> cineplexListing = (ArrayList<Cineplex>) ois.readObject();
            ois.close();
            return cineplexListing;
        } catch (ClassNotFoundException | IOException e) {
            // ignore error
        }
        return new ArrayList<Cineplex>();
    }; 

    
    /** 
     * READ and return Cineplex based on name passed in the Database file
     * @param name          Name of cineplex to search for
     * @return Cineplex     Return Cineplex if found, else null object
     */
    public Cineplex readByName(String name){
        ArrayList<Cineplex> allData = read();
        for (int i=0; i<allData.size(); i++){
            Cineplex c = allData.get(i);
            if (c.getName().equals(name))
                return c;
        }
        return null;
    };

    
    /**
     * UPDATE a Cineplex's name based on a given cineplex's name in Database file 
     * @param oldName   Name of cineplex to search for
     * @param newName   New name of cineplex to update with
     */
    public void updateByName(String oldName, String newName){
        
        if (CineplexesLayer.isEmpty_name(newName)){
            // do nothing
        } else {
            ArrayList<Cineplex> allData = read();
            ArrayList<Cineplex> returnData = new ArrayList<Cineplex>();
                    
            for (int i=0; i<allData.size(); i++){
                Cineplex c = allData.get(i);
                if (c.getName().equals(oldName))
                    c.setName(newName);
                returnData.add(c);
            }
            replaceExistingFile(FILENAME, returnData);
        }
    }

    
    /** 
     * Delete an Cineplex in the Database file, based on the name attribute passed
     * @param name  Name of Cineplex which will be deleted
     */
    public void deleteByName(String name){
        ArrayList<Cineplex> allData = read();
        ArrayList<Cineplex> returnData = new ArrayList<Cineplex>();
        
        for (int i=0; i<allData.size(); i++){
            Cineplex c = allData.get(i);
            if (!c.getName().equals(name))
                returnData.add(c);
        }

        replaceExistingFile(FILENAME, returnData);
    }

    
    /** 
     * Overwrite Database file with new data of list of Admin
     * @param filename      Filename to check for
     * @param data    New ArrayList of Cineplex to be written to the file
     */
    public void replaceExistingFile(String filename, ArrayList<Cineplex> data){
        File tempFile = new File(filename);
        if (tempFile.exists()) 
            tempFile.delete();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(data);
            out.flush();
            out.close();
        } catch (IOException e) {
            // ignore error
        }
    }
}