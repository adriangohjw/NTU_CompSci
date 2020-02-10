package Model;

import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * Represents a Transaction (or Booking)
 */
@SuppressWarnings("serial")
public class Transaction implements Serializable {

	/**
	 * Transaction ID of the Transaction
	 * In the format of XXXYYYYMMDDhhmm
	 * XXX is the cinema code
	 * YYYYDDMMhhmm is datetime
	 */
	private String TID;

	/**
	 * Name of MovieGoer who made the Transaction
	 */
	private String name;

	/**
	 * Email of MovieGoer who made the Transaction
	 */
	private String email;

	/**
	 * Mobile number of MovieGoer who made the Transaction
	 */
	private String mobileNumber;

	/**
	 * Movie in which the Transaction is made for
	 */
	private Movie movie;
	
	/**
	 * Creates a Transaction with the given attributes
	 * @param cinemaCode		Cinema code in which the movie and session is being held
	 * @param name				Name of MovieGoer who made the Transaction
	 * @param email				Email of MovieGoer who made the Transaction
	 * @param mobileNumber		Mobile number of MovieGoer who made the Transaction
	 * @param movie				Movie in which the Transaction is made for
	 */
	public Transaction(String cinemaCode, String name, String email, String mobileNumber, Movie movie) {
		String formattedTimestamp = new SimpleDateFormat("YYYYMMddHHmm").format(new Date());
		this.TID = cinemaCode.concat(formattedTimestamp);
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.movie = movie;
	}

	
	/** 
	 * Get the Transaction ID of the Transaction
	 * @return String	Transaction ID of this Transaction
	 */
	public String getTID() {
		return TID;
	}

	
	/** 
	 * Get the name of the MovieGoer who made this Transaction
	 * @return String	Name of MovieGoer
	 */
	public String getName(){
		return name;
	}

	
	/** 
	 * Get the email of the MovieGoer who made this Transaction
	 * @return String	Email of MovieGoer
	 */
	public String getEmail(){
		return email;
	}

	
	/** 
	 * Get the mobile number of the MovieGoer who made this Transaction
	 * @return String	Mobile numer of MovieGoer
	 */
	public String getMobileNumber(){
		return mobileNumber;
	}

	
	/** 
	 * Get the mobie which the Transaction is made for
	 * @return Movie	Movie of this Transaction
	 */
	public Movie getMovie(){
		return movie;
	}

	
	/** 
	 * String to return when this Movie_Goer is being called
	 * @return String	
	 */
	public String toString(){
		String toReturn = "";
		toReturn 	+= "TID: " + getTID() + "\t"
					+ "Movie: " + getMovie().getTitle() + "\n"
					+ "Name: " + getName() + "\n"
					+ "Mobile number: " + getMobileNumber() + "\n";
		return toReturn; 
	}
}
