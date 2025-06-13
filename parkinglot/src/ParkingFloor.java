import java.util.*;
import java.util.stream.Collectors;

public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber, List<ParkingSpot> spot) {
        this.floorNumber = floorNumber;
        this.parkingSpots = new ArrayList<>(spot);
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public synchronized ParkingSpot getAvailableSpot(VehicleType type) {
        try {
            return parkingSpots.stream().filter(spot -> spot.isAvailable() && spot.getType() == type).findFirst().get();
        } catch (RuntimeException e) {
            return null;
        }
    }

    public List<ParkingSpot> getAllAvailableSpot(VehicleType type) {
        return parkingSpots.stream().filter(spot -> spot.isAvailable() && spot.getType() == type).collect(Collectors.toList());
    }
}
