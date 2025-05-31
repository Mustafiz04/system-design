public class ParkingSlot {
    String name;
    boolean isAvailable = true;
    Vehicle vehicle;
    ParlingSlotType parlingSlotType;

    public ParkingSlot(String name, ParlingSlotType parlingSlotType) {
        this.name = name;
        this.parlingSlotType = parlingSlotType;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isAvailable = false;
    }

    public void removeVehicle(Vehicle vehicle){
        this.vehicle = null;
        this.isAvailable = true;
    }
}
