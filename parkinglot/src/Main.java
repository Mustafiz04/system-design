import java.util.*;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        
        ParkingSpot spot1 = new ParkingSpot("A1", VehicleType.CAR);
        ParkingSpot spot2 = new ParkingSpot("B1", VehicleType.BIKE);
        ParkingSpot spot3 = new ParkingSpot("C1", VehicleType.TRUCK);
        ArrayList<ParkingSpot> floorOneSpot = new ArrayList<>();
        floorOneSpot.add(spot1);
        floorOneSpot.add(spot2);
        floorOneSpot.add(spot3);
        ParkingFloor floor1 = new ParkingFloor(1, floorOneSpot);

        ParkingSpot spot4 = new ParkingSpot("A2", VehicleType.CAR);
        ParkingSpot spot5 = new ParkingSpot("B2", VehicleType.BIKE);
        ParkingSpot spot6 = new ParkingSpot("C2", VehicleType.TRUCK);
        ArrayList<ParkingSpot> floorTwoSpot = new ArrayList<>();
        floorTwoSpot.add(spot4);
        floorTwoSpot.add(spot5);
        floorTwoSpot.add(spot6);
        ParkingFloor floor2 = new ParkingFloor(2, floorTwoSpot);

        ParkingSpot spot7 = new ParkingSpot("A3", VehicleType.CAR);
        ParkingSpot spot8 = new ParkingSpot("B3", VehicleType.BIKE);
        ParkingSpot spot9 = new ParkingSpot("C3", VehicleType.TRUCK);
        ArrayList<ParkingSpot> floorThreeSpot = new ArrayList<>();
        floorThreeSpot.add(spot7);
        floorThreeSpot.add(spot8);
        floorThreeSpot.add(spot9);
        ParkingFloor floor3 = new ParkingFloor(3, floorThreeSpot);

        parkingLot.getFloors().add(floor1);
        parkingLot.getFloors().add(floor2);
        parkingLot.getFloors().add(floor3);

        Vehicle car = new Car("CAR123");
        Ticket ticket = parkingLot.parkVehicle(car);
        System.out.println("Parked Vehicle: " + car.getLicensePlate() + " with Ticket ID: " + ticket.getTicketId());

//         View available spots
        System.out.println("Available spots for Car:");
        for (ParkingFloor floor: parkingLot.getFloors()) {
            System.out.println("Floor: " + floor.getFloorNumber() + " " + floor.getAvailableSpot(VehicleType.CAR));
        }

        List<String> parkingTickets = new ArrayList<>();

        // Park vehicles
        try {
            Ticket ticket1 = parkingLot.parkVehicle(new Car("DL0123"));
            System.out.println("Car 1 parked: " + ticket1.getTicketId());
            parkingTickets.add(ticket1.getTicketId());

            Ticket ticket2 = parkingLot.parkVehicle(new Car("DL0456"));
            System.out.println("Car 2 parked: " + ticket2.getTicketId());
            parkingTickets.add(ticket2.getTicketId());

            Ticket ticket3 = parkingLot.parkVehicle(new Bike("DL0789"));
            System.out.println("Bike 1 parked: " + ticket3.getTicketId());
            parkingTickets.add(ticket3.getTicketId());

            // Try parking another car when spots are full
            Vehicle car3 = new Car("DL0432");
            parkingLot.parkVehicle(car3);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

//        parkingLot.getActiveTicket().forEach((ticketId, tickett) -> {
//            System.out.println("Active Ticket ID: " + ticketId + ", Vehicle: " + tickett.getVehicle().getLicensePlate());
//        });

    }
}