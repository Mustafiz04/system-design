package airlinemanagementsystem;

import airlinemanagementsystem.flight.Domestic;
import airlinemanagementsystem.flight.Flight;
import airlinemanagementsystem.flight.International;
import airlinemanagementsystem.seat.Seat;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        AirlineManagementSystem system = new AirlineManagementSystem();

        Passenger doe = system.addPassenger("John Doe", "8765423" ,"john@example.com");
        Passenger smith = system.addPassenger("John Smith", "6786544", "smith@example.com");

        Aircraft boeing = system.addAircraft("Boeing 737", 180);
        Aircraft airbus = system.addAircraft("Airbus A320", 150);

        Flight flight1 = new Domestic("NYC", "LAX", LocalDateTime.of(2023, 10, 1, 10, 0), LocalDateTime.of(2023, 10, 1, 13, 0), boeing);
        Flight flight2 = new Domestic("LAX", "SFO", LocalDateTime.of(2023, 10, 1, 15, 0), LocalDateTime.of(2023, 10, 1, 16, 30), airbus);
        Flight flight3 = new International("SFO", "TKY", LocalDateTime.of(2023, 10, 1, 18, 0), LocalDateTime.of(2023, 10, 1, 20, 0), airbus);

        system.addFlight(Arrays.asList(flight1, flight2, flight3));

        List<Flight> flights = system.searchFlight("NYC", "LAX", LocalDateTime.of(2023, 10, 1, 8, 0));
        if (flights.isEmpty()) {
            System.out.println("No flights found.");
        } else {
            System.out.println("Available flights:");
            for (Flight flight : flights) {
                System.out.println("Flight Number: " + flight.getFlightNumber() + ", Source: " + flight.getSource() + ", Destination: " + flight.getDestination());
            }
        }

        // Example booking
        Seat seat = flight1.getAvailableSeats().get(0);
    }
}
