package airlinemanagementsystem;

import airlinemanagementsystem.booking.Booking;
import airlinemanagementsystem.booking.BookingManager;
import airlinemanagementsystem.flight.Flight;
import airlinemanagementsystem.payment.Payment;
import airlinemanagementsystem.payment.PaymentProcessor;
import airlinemanagementsystem.seat.Seat;

import java.time.LocalDateTime;
import java.util.*;

public class AirlineManagementSystem {
    private final Map<String, Flight> flights;
    private final Map<String, Passenger> passengers;
    private final Map<String, Aircraft> aircrafts;
    private final Map<String, Booking> bookings;
    private final BookingManager bookingManager;
    private final PaymentProcessor paymentProcessor;

    public AirlineManagementSystem() {
        this.flights = new HashMap<>();
        this.passengers = new HashMap<>();
        this.aircrafts = new HashMap<>();
        this.bookings = new HashMap<>();
        this.bookingManager = BookingManager.getInstance();
        this.paymentProcessor = PaymentProcessor.getInstance();
    }

    public Passenger addPassenger(String name, String passportNumber, String email) {
        Passenger passenger = new Passenger(name, passportNumber, email);
        String passengerId = passenger.getId();
        synchronized (passengerId) {
            passengers.put(passengerId, passenger);
        }
        return passenger;
    }

    public Aircraft addAircraft(String model, int capacity) {
        Aircraft aircraft = new Aircraft(model, capacity);
        String aircraftId = aircraft.getId();
        synchronized (aircraftId) {
            aircrafts.put(aircraftId, aircraft);
        }
        return aircraft;
    }

    public void addFlight(List<Flight> flights) {
        for(Flight flight : flights) {
            String flightNumber = flight.getFlightNumber();
            synchronized (flightNumber) {
                this.flights.put(flightNumber, flight);
            }
        }
    }

    public List<Flight> searchFlight(String source, String destination, LocalDateTime departureTime) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights.values()) {
            if (flight.getSource().equalsIgnoreCase(source) &&
                flight.getDestination().equalsIgnoreCase(destination) &&
                flight.getDepartureTime().isAfter(departureTime)) {
                result.add(flight);
            }
        }
        return result;
    }

    public Booking bookFlight(Passenger passenger, Flight flight, Seat seat, double price) {
        if (!passengers.containsKey(passenger.getId())) {
            throw new NoSuchElementException("Passenger not found.");
        }
        if (!flights.containsKey(flight.getFlightNumber())) {
            throw new NoSuchElementException("Flight not found.");
        }
        Booking booking = bookingManager.createBooking(flight, passenger, seat, price);
        bookings.put(booking.getId(), booking);
        return booking;
    }

    public void cancelBooking(String bookingId) {
        if (!bookings.containsKey(bookingId)) {
            throw new NoSuchElementException("Booking not found.");
        }
        bookingManager.cancelBooking(bookingId);
        bookings.remove(bookingId);
    }

    public void processPayment(Payment payment) {

    }
}
