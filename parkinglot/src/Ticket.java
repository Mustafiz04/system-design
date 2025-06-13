public class Ticket {
    public final String ticketId;
    public final Vehicle vehicle;
    public final ParkingSpot parkingSpot;
    public final long issueTime;
    public long exitTime;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.vehicle = vehicle;
        this.ticketId = ticketId;
        this.parkingSpot = parkingSpot;
        this.issueTime = System.currentTimeMillis();
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public long getIssueTime() {
        return issueTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }
}
