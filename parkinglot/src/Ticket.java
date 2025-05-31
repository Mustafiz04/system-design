public class Ticket {
    String ticketNumber;
    long startTime;
    long endTime;
    Vehicle vehicle;
    ParkingSlot parkingSlot;

    public Ticket(Vehicle vehicle, ParkingSlot parkingSlot) {
        this.ticketNumber = (vehicle.getVehicleNumber() + System.currentTimeMillis());
        this.startTime = System.currentTimeMillis();
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
    }
}
