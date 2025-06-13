public class ParkingSpot {
    private final String id;
    private Vehicle vehicle;
    private final VehicleType type;
    private boolean isOccupied;

    public ParkingSpot(String id, VehicleType type) {
        this.id = id;
        this.type = type;
        this.isOccupied = false;
    }

    public synchronized boolean isAvailable() {
        return !isOccupied;
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        if( !isAvailable() || vehicle.getType() != type ) {
            return false;
        }
        this.vehicle = vehicle;
        isOccupied = true;
        return true;
    }

    public synchronized boolean unpark() {
        if( !isOccupied ) {
            return false;
        }
        this.vehicle = null;
        this.isOccupied = false;
        return true;
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleType getType() {
        return type;
    }
}
