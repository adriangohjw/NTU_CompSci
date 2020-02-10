package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a Cinema
 * A cinema has a type, seating plan and list of sessions in that cinema
 */
@SuppressWarnings("serial")
public class Cinema implements Serializable {

	 /**
	  * This Cinema's code
	  */
	private String code;

	/**
	 * This Cinema's type
	 */
	private CinemaType cinemaType;

	/**
	 * This Cinema's seating plan
	 */
	protected SeatingPlan seatingPlan;

	/**
	 * This Cinema's list of sessions
	 */
	private ArrayList<Session> sessions;
	
	
	/** 
	 * Creates a Cinema with the given attributes
	 * Default for sessions is empty (no sessions assigned to cinema during creation)
	 * @param code			This Cinema's code
	 * @param cinemaType	This Cinema's type
	 * @param seatingPlan 	This Cinema's seating plan
	 */
	public Cinema (String code, CinemaType cinemaType, SeatingPlan seatingPlan) {
		this.code = code;
		this.cinemaType = cinemaType;
		this.seatingPlan = seatingPlan;
		this.sessions = new ArrayList<Session>();
	}
	
	
	/** 
	 * Get the code of this Cinema
	 * @return String	this Cinema's code
	 */
	public String getCode() {
		return code;
	}
	
	/** 
	 * Change the code of this Cinema
	 * @param code 		this Cinema's new code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	
	/** 
	 * Get the cinema type of this Cinema
	 * @return CinemaType	this Cinema's type
	 */
	public CinemaType getCinemaType() {
		return cinemaType;
	}
	
	
	/** 
	 * Change the cinema type of this Cinema
	 * @param cinemaClass	this Cinema's new type
	 */
	public void setCinemaType(CinemaType cinemaClass) {
		this.cinemaType = cinemaClass;
	}

	
	/** 
	 * Get the seating plan of this Cinema
	 * @return SeatingPlan	this Cinema's seating plan
	 */
	public SeatingPlan getSeatingPlan() {
		return seatingPlan;
	}

	
	/** 
	 * Change the seating plan of this Cinema
	 * @param seatingPlan	this Cinema' new seating plan
	 */
	public void setSeatingPlan(SeatingPlan seatingPlan) {
		this.seatingPlan = seatingPlan;
	}

	
	/** 
	 * Get the list of sessions for this Cinema
	 * @return Model.{@link Session}	this Cinema's list of sessions
	 */
	public ArrayList<Session> getSessions() {
		return sessions;
	}

	
	/** 
	 * Change the list of sessions for this Cinema
	 * @param sessions		this Cinema's new list of sessions
	 */
	public void setSessions(ArrayList<Session> sessions) {
		this.sessions = sessions;
	}

	
	/** 
	 * String to return when this Cinema is being called
	 * @return String
	 */
	public String toString(){
		String sessionsString = "";
		for (int i=0; i<sessions.size(); i++)
			sessionsString = sessionsString.concat("-----" + sessions.get(i) + "\n");
		sessionsString = sessionsString.substring(0, sessionsString.length());
		
		String details = "";
		details += "Cinema code: " + getCode() + "\n"
				+ "Cinema type: " + getCinemaType() + "\n"
				+ "Sessions: " + getSessions().size() +"\n" 
				+ sessionsString;
		return details;
	}	
}
