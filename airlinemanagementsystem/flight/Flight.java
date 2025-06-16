package airlinemanagementsystem.flight;

import airlinemanagementsystem.Aircraft;
import airlinemanagementsystem.seat.Seat;

import java.time.*;
import java.util.*;

public class Flight {
    private final String flightNumber;
    private final String source;
    private final String destination;
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;
    private final Aircraft aircraft;
    private final FlightType flightType;
    private final FlightStatus status;
    private final Map<String, Seat> seats;
    private final List<Seat> availableSeats;

    public Flight(String source, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime, Aircraft aircraft, FlightType flightType) {
        this.flightNumber = UUID.randomUUID().toString();
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.aircraft = aircraft;
        this.flightType = flightType;
        this.status = FlightStatus.SCHEDULED;
        this.seats = new HashMap<>();
        this.availableSeats = new ArrayList<>();
    }


    // GETTERS
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public Map<String, Seat> getSeats() {
        return seats;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }
}
