package lab3;

import java.util.Arrays;

public class Plane {
	
	private int numEmptySeat;
	private PlaneSeat[] seat = new PlaneSeat[12];
	private PlaneSeat[] seatTemp = new PlaneSeat[12];
	
	public Plane() {
		this.numEmptySeat = 12;
		for (int i=0; i<12; i++) {
			this.seat[i] = new PlaneSeat(i);
		}
		for (int i=0; i<12; i++) {
			this.seatTemp[i] = new PlaneSeat(i);
		}
	}
	
	private PlaneSeat[] sortSeats() {
		
		// custIDArrTemp to store array of customerID
		int[] custIDArrTemp = new int[12-this.numEmptySeat];
		int counter = 0;
		for (int i=0; i<12; i++) {
			if (this.seat[i].isOccupied()) {
				custIDArrTemp[counter++] = this.seat[i].getCustomerID();
			}
		}

		Arrays.sort(custIDArrTemp); // customerID sorted in ascending order
		
		// creating a temporary PlaneSeat
		PlaneSeat[] planeSeatTemp = new PlaneSeat[12];
		for (int i=0; i<12; i++) {
			planeSeatTemp[i] = new PlaneSeat(i);
		}
		
		// storing the position (based on ascending customerID) as the customerID of the new PlaneSeat
		for (int i=0; i<custIDArrTemp.length; i++) { // looping through Array
			for (int j=0; j<12; j++) { // looping through temporary PlaneSeat
				if (custIDArrTemp[i] == this.seat[j].getCustomerID()) {
					planeSeatTemp[j].assign(i);
					break;
				}
			}
		}
		
		return planeSeatTemp;
	}
	
	public void showNumEmptySeats() {
		System.out.println("There are " + this.numEmptySeat + " empty seats");
	}
	
	public void showEmptySeats() {
		System.out.println("The following seats are empty:");
		for (int i=0; i<this.seat.length; i++) {
			if (this.seat[i].isOccupied() == false) {
				System.out.println("SeatID " + (i+1));
			}
		}
	}
	
	public void showAssignedSeat(boolean bySeatId) {
		System.out.println("The seat assignments are as follow:");
		if (bySeatId) {
			for (int i=0; i<this.seat.length; i++) {
				if (this.seat[i].isOccupied()) {
					System.out.println("SeatID " + (i+1) + " assigned to CustomerID " + this.seat[i].getCustomerID() + ".");
				}
			}
		} else { 
			PlaneSeat[] seatTemp = sortSeats();
			for (int i=0; i<this.numEmptySeat; i++) { // looping through the position counter
				for (int j=0; j<this.seat.length; j++) { // looping through temporary seat array
					if (seatTemp[j].getCustomerID() == i) {
						System.out.println("SeatID " + (j+1) + " assigned to CustomerID " + this.seat[j].getCustomerID() + ".");
						break;
					}
				}	
			}
		}
	}
	
	public void assignSeat(int seatId, int cust_id) {
		if (this.seat[seatId-1].isOccupied()) {
			System.out.println("Seat already assigned to a customer.");
		} else {
			this.seat[seatId-1].assign(cust_id);
			this.numEmptySeat--;
			System.out.println("Seat Assigned!");
		}
	}
	
	public void unAssignSeat(int seatId) {
		this.seat[seatId-1].unAssign();
		this.numEmptySeat++;
		System.out.println("Seat Unassigned!");
	}
	
}
