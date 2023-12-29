public interface Parking {
    public Ticket park(Vehicle vehicle) throws ParkingFullException;
    public int unpark(Ticket ticket, ParkingStrategy parkingStrategy) throws InvalidVehicleNumberException;
}
