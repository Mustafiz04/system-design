package vehicle;

public abstract class Vehicle {
    private String licenceNumber;
    private final VehicleType type;
//    private ParkingTicket ticket;


    public Vehicle(String licenceNumber, VehicleType type) {
        this.licenceNumber = licenceNumber;
        this.type = type;
    }
}
