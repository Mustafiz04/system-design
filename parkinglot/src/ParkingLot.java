import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    public final List<ParkingFloor> floors;
    public final Map<String, Ticket> activeTicket = new ConcurrentHashMap<>();
    private FeeStrategy feeStrategy;

    public ParkingLot() {
        this.floors = new ArrayList<>();;
        this.feeStrategy = new FlatRateFeeStrategy();
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle) {
        for(ParkingFloor floor: floors) {
            ParkingSpot availableSpot = floor.getAvailableSpot(vehicle.getType());
            if( availableSpot != null && availableSpot.isAvailable() ) {
                if( availableSpot.parkVehicle(vehicle) ) {
                    String ticketId = UUID.randomUUID().toString();
                    Ticket ticket = new Ticket(ticketId, vehicle, availableSpot);
                    activeTicket.put(ticketId, ticket);
                    return ticket;
                }
            }
        }
        throw new RuntimeException("No available parking spot for vehicle type: " + vehicle.getType());
    }

    public synchronized double unpark(String ticketId) {
        Ticket ticket = activeTicket.get(ticketId);
        if( ticket == null ) {
            throw new RuntimeException("Invalid ticket ID: " + ticketId);
        }
        activeTicket.remove(ticketId);
        ParkingSpot spot = ticket.getParkingSpot();
        spot.unpark();

        ticket.setExitTime(System.currentTimeMillis());

        return feeStrategy.calculateFee(ticket);
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public Map<String, Ticket> getActiveTicket() {
        return activeTicket;
    }

    public FeeStrategy getFeeStrategy() {
        return feeStrategy;
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }
}
