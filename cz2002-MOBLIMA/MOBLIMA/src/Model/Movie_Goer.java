package Model;

import java.security.NoSuchAlgorithmException;

/**
 * Represents an MovieGoer with access to the system
 * An MovieGoer has very limited rights (mostly READ and CREATE)
 */
@SuppressWarnings("serial")
public class Movie_Goer extends User {
	
	/**
	 * @param name 			this Movie_Goer's name
	 * @param password		this Movie_Goer's password
	*/
	
	/**
	 * This Movie_Goer's name
	 */
	private String name;

	/**
	 * This Movie_Goer's mobile number
	 */
	private String mobileNumber;

	
	/** 
	 * Creates a Movie_Goer with the given attributes
	 * Used when only username and password of MovieGoer known during account creation
	 * @param username						This Admin's username (email)
	 * @param password						This Admin's password (unencrypted)
	 * @throws NoSuchAlgorithmException		Thrown due to SHA256 encryption required but not available in the environment
	 */
	public Movie_Goer(String username, String password) 
			throws NoSuchAlgorithmException {
		super(username, password, MOVIE_GOER);
	}

	
	/** 
	 * Creates a Movie_Goer with the given attributes
	 * Used when all information of MovieGoer (including name and mobile number) known during account creation
	 * @param username						This MovieGoer's username (email)
	 * @param password						This MovieGoer's password (unencrypted)
	 * @param name							This MovieGoer's name
	 * @param mobileNumber					This MovieGoer's mobile number
	 * @throws NoSuchAlgorithmException		Thrown due to SHA256 encryption required but not available in the environment
	 */
	public Movie_Goer(String username, String password, String name, String mobileNumber) 
			throws NoSuchAlgorithmException {
		super(username, password, MOVIE_GOER);
		this.name = name;
		this.mobileNumber = mobileNumber;
	}

	
	/** 
	 * Get the name of this Movie_Goer
	 * @return String	this Movie_Goer's name
	 */
	public String getName() {
		return name;
	}

	
	/** 
	 * Change the name of this Movie_Goer
	 * @param name	this Movie_Goer's new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/** 
	 * Get the mobile number of this Movie_Goer
	 * @return String	this Movie_Goer's mobile number
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	
	/** 
	 * Change the mobile number of this Movie_Goer
	 * @param mobileNumber	this Movie_Goer's new mobile number
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	/** 
	 * String to return when this Movie_Goer is being called
	 * @return String	
	 */
	public String toString(){
		String toReturn = "";
		toReturn 	+= "Username: " + getName() + "\n"
					+ "E-mail: " + getEmail() + "\n"
					+ "Mobile number: " + getMobileNumber();
		return toReturn; 
	}
}
