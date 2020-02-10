package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a Cineplex in the system
 * A Cineplex has at least 3 cinemas
 */
@SuppressWarnings("serial")
public class Cineplex implements Serializable {

	/**
	 * this Cineplex's name
	 */
	private String name;

	/** 
	 * this Cineplex's list of cinemas
	 * every cineplex must have at least 3 cinemas
	 */
	private ArrayList<Cinema> cinemas;  // at least 3 cinemas
	
	
	/** 
	 * Creates a Cineplex with the given attributes
	 * A Cineplexhas at least 3 cinemas
	 * @param name		this Cineplex's name
	 * @param cinemas	this Cineplex's list of cinemas
	 */
	public Cineplex(String name, ArrayList<Cinema> cinemas) {
		this.name = name;
		this.cinemas = cinemas;
	}
	
	
	/** 
	 * Get the name of this Cineplex
	 * @return String	this Cineplex's name
	 */
	public String getName() {
		return name;
	}
	
	
	/** 
	 * Change the name of this Cineplex
	 * @param name		this Cineplex's new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	/** 
	 * Get the list of cinemas for this Cineplex
	 * @return Model.{@link Cinema}	this Cineplex's list of cinemas
	 */
	public ArrayList<Cinema> getCinemas() {
		return cinemas;
	}
	
	
	/** 
	 * Change the list of cinemas for this Cineplex
	 * @param cinemas	this Cineplex's new list of cinemas
	 */
	public void setCinemas(ArrayList<Cinema> cinemas) {
		this.cinemas = cinemas;
	}

	
	/** 
	 * String to return when this Cineplex is being called
	 * @return String
	 */
	public String toString(){
        String cinemaString = "";
        for (int i=0; i<getCinemas().size(); i++)
			cinemaString = cinemaString.concat(getCinemas().get(i) + ",\n");
		cinemaString = cinemaString.substring(0, cinemaString.length()-2);

        String details = "";
        details += "Name: " + getName() + "\n"
				+ cinemaString; 
        return details;
    }
}