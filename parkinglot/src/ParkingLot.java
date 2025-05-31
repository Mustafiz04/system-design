import java.util.List;
import java.util.Map;

public class ParkingLot {
    private String name;
    private Address address;
    private List<ParkingFloor> parkingFloors;
    private static ParkingLot parkingLot = null;


    public ParkingLot(String name, Address address, List<ParkingFloor> floor) {
        this.name = name;
        this.address = address;
        this.parkingFloors = floor;
    }

    public static ParkingLot getInstance(String name, Address address, List<ParkingFloor> floor) {
        if(parkingLot != null) {
            parkingLot = new ParkingLot(name, address, floor);
        }
        return parkingLot;
    }

    public void addFloor(String name,  Map<ParlingSlotType, Map<String, ParkingSlot>> slots) {
        ParkingFloor parkingFloor = new ParkingFloor(name, slots);
        this.parkingFloors.add(parkingFloor);
    }

    public void removeFloor(ParkingFloor parkingFloor) {
        parkingFloors.remove(parkingFloor);
    }

    public Ticket assignTicket (Vehicle vehicle) {
        ParkingSlot parkingSlot = getRelevantSlotForVehicleAndPark(vehicle);
        if(parkingSlot == null) return null;
        Ticket ticket = createTicketForSlot(parkingSlot, vehicle);
        return ticket;
    }

    public double scanAndPay(Ticket ticket) {
        long endTime = System.currentTimeMillis();
        ticket.parkingSlot.removeVehicle(ticket.vehicle);
        int duration = (int) (endTime - ticket.startTime) / 1000;
        double price = getPrice(duration, ticket.parkingSlot.parlingSlotType);
        return price;
    }

    private double getPrice(int duration, ParlingSlotType parlingSlotType) {
        return 0;
    }

    public Ticket createTicketForSlot(ParkingSlot parkingSlot, Vehicle vehicle) {
        return new Ticket(vehicle, parkingSlot);
    }

    public ParkingSlot getRelevantSlotForVehicleAndPark(Vehicle vehicle) {
        ParkingSlot slot = null;
        for(ParkingFloor floor : parkingFloors) {
            slot = floor.getRelevantSlotForVehicleAndPark(vehicle);
            if(slot != null) return slot;
        }
        return null;
    }

}
