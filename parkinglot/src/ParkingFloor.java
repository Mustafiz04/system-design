import java.util.Map;

public class ParkingFloor {
    String name;
    Map<ParlingSlotType, Map<String, ParkingSlot>> slots;

    public ParkingFloor(String name, Map<ParlingSlotType, Map<String, ParkingSlot>> slots) {
        this.name = name;
        this.slots = slots;
    }

    public ParkingSlot getRelevantSlotForVehicleAndPark(Vehicle vehicle) {
        VehicleCategory vehicleCategory = vehicle.getVehicleType();
        ParlingSlotType parkingSlotType = pickCorrectSlotType(vehicleCategory);
        Map<String, ParkingSlot> relevantParkingSlots = slots.get(parkingSlotType);
        ParkingSlot parkingSlot = null;
        for(Map.Entry<String, ParkingSlot> m: relevantParkingSlots.entrySet()) {
            if(m.getValue().isAvailable) {
                parkingSlot = m.getValue();
                parkingSlot.addVehicle(vehicle);
            }
        }
        return parkingSlot;
    }

    public ParlingSlotType pickCorrectSlotType (VehicleCategory vehicleCategory) {
        switch (vehicleCategory) {
            case TWO_WHEELER:
                return ParlingSlotType.TWO_WHEELER;
            case SEDAN:
                return ParlingSlotType.COMPACT;
            case SUV:
                return ParlingSlotType.MEDIUM;
            case BUS:
                return ParlingSlotType.LARGE;
            default:
                return null;
        }
    }
}
