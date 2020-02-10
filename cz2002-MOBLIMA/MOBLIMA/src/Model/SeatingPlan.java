package Model;

import java.io.Serializable;

/**
 * Represents a SeatingPlan 
 * SeatingPlan will be used to be assigned to Cinema
 * Seats are labelled 1,2,3....x where x is the number of columns
 * The first ID of seat at each row is 1, x+1, 2x+1... 
 */
@SuppressWarnings("serial")
public class SeatingPlan implements Serializable {

	/** 
	 * This SeatingPlan's layout with a matrix of rows and columns
	 */
	private Seat [][] layout;

	/**
	 * This SeatingPlan's number of rows
	 */
	private int row;

	/**
	 * This SeatingPlan's number of columns
	 */
	private int column;
	
	
	/** 
	 * Creates a SeatingPlan with the given attributes
	 * @param row		This SeatingPlan's number of rows
	 * @param column	This SeatingPlan's number of columns
	 */
	public SeatingPlan(int row, int column) {
		this.row = row;
		this.column = column;
		layout = new Seat [row][column];
		for (int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++)
				layout[i][j] = new Seat(i*this.row+j);
		}
	}
	
	/**
	 * Print the layout of this SeatingPlan
	 * Displayed in a matrix of rows and columns
	 * X represented occupied
	 * 0 represented not occupied
	 */
	public void printLayout( ) {
		System.out.print("\nX means occupied, 0 means not occupied.\n");
		for (int i = 0; i < row; i++) {
			System.out.print("Seats " + (i * column) + " - " + ((i + 1) * column - 1) + ":\t");
			for (int j = 0; j < column; j++) {
				if(layout[i][j].isOccupied()) System.out.print("X ");
				else System.out.print("0 ");
				if(j == column/2 - 1) System.out.print("\t");
			}
			System.out.print("\n");
		}
	}

	
	/** 
	 * Get the number of rows of this SeatingPlan
	 * @return int	This SeatingPlan's number of rows
	 */
	public int getRow() {
		return row;
	}
	
	
	/** 
	 * Get the number of columns of this SeatingPlan
	 * @return int	This SeatingPlan's number of columns
	 */
	public int getColumn() {
		return column;
	}
	
	
	/** 
	 * Get the total number of seats of this SeatingPlan
	 * It can be calculated by multiplying number of rows and number of columns
	 * @return int
	 */
	public int getNumSeats() {
		return row*column;
	}
	
	
	/** 
	 * Set the occupancy status of seat at ID to "occupied"
	 * @param id	ID of seat to be updated to "occupied"
	 */
	public void assignSeats(int id) {
		int i = id/row;
		layout[i][id - row*i].assign();
	}
	
	
	/** 
	 * Set the occupancy status of seat at ID to "unoccupied"
	 * @param id	ID of seat to be updated to "unoccupied"
	 */
	public void unassignSeats(int id) {
		int i = id/row;
		layout[i][id - row*i].unassign();
	}
	
	
	/** 
	 * Check if a particular seat is taken
	 * @param id			Occupancy status of Seat at this ID is returned
	 * @return boolean		Occupancy status of Seat is returned
	 */
	public boolean checkSeats(int id) {
		int i = id/row;
		return layout[i][id - row*i].isOccupied();
	}
}
