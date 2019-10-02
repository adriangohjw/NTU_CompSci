package lab3;

public class Plane {
	
	private PlaneSeat[] seat = new PlaneSeat[12];
	private int numEmptySeat;
	
	public Plane() {
	}
	
	private PlaneSeat[] sortSeats() {
		// to add code for sorting seats by customerID
	}
	
	public void showNumEmptySeats() {
		this.numEmptySeat = 0;
		for (int i=0; i<seat.length; i++) {
			if (seat[i].isOccupied() == false) {
				this.numEmptySeat++;
			} 
		}
		System.out.println("There are " + this.numEmptySeat + " empty seats");
	}
	
	public void showEmptySeats() {
		System.out.println("The following seats are empty:");
		for (int i=0; i<seat.length; i++) {
			if (seat[i].isOccupied() == false) {
				System.out.println("SeatID " + (i+1));
			}
		}
	}
	
	public void showAssignedSeat(boolean bySeatId) {
		System.out.println("The seat assignments are as follow:");
		if (bySeatId) {
			for (int i=0; i<seat.length; i++) {
				if (seat[i].isOccupied()) {
					System.out.println("SeatID " + (i+1)+ " assigned to CustomerID " + seat[i].getCustomerID() + ".");
				}
			}
		} else { 
			// to add code for sorting by seatID
		}
	}
	
	public void assignSeat(int seatId, int cust_id) {
		if (seat[seatId-1].isOccupied()) {
			System.out.println("Seat already assigned to a customer.");
		} else {
			seat[seatId-1].assign(cust_id);
			System.out.println("Seat Assigned!");
		}
	}
	
	public void unAssignSeat(int seatId) {
		seat[seatId-1].unAssign();
	}
	
}
