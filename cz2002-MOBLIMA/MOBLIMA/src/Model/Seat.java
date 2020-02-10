package Model;

import java.io.Serializable;

/**
 * Represents a Seat in the SeatingPlan
 */
@SuppressWarnings("serial")
public class Seat implements Serializable {

	/**
	 * The ID of this Seat
	 */
	private int seatID;

	/**
	 * The occupancy status of this Seat
	 * If true, seat is occupied
	 * Else, seat is empty
	 */
	private boolean occupied = false;
	
	
	/** 
	 * Creates a Seat with the given attribute
	 * By default, seat is empty
	 * @param id		This Seat's ID
	 */
	public Seat(int id) {
		seatID = id;
	}
	
	
	/** 
	 * Creates a Seat with the given attribute
	 * @param id		This Seat's ID
	 * @param state		This Seat's occupancy status
	 */
	public Seat(int id, boolean state) {
		seatID = id;
		occupied = state;
	}
	
	
	/** 
	 * Get the ID of this Seat
	 * @return int	This Seat's ID
	 */
	public int getSeatID() {
		return seatID;
	}
	
	
	/** 
	 * Get the occupancy status of this Seat
	 * @return boolean	This Seat's occupancy status
	 */
	public boolean isOccupied() {
		return occupied;
	}
	
	/**
	 * Set the occupancy status of this seat to be "occupied" (true)
	 */
	public void assign() {
		occupied = true;
	}

	/**
	 * Set the occupancy status of this seat to be "empty" (false)
	 */
	public void unassign() {
		occupied = false;
	}
}
