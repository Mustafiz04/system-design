package airlinemanagementsystem.booking;

import airlinemanagementsystem.Passenger;
import airlinemanagementsystem.flight.Flight;
import airlinemanagementsystem.seat.Seat;

import java.util.UUID;

public class Booking {
    private final String id;
    private final Flight flight;
    private final Passenger passenger;
    private final Seat seat;
    private final double price;
    private BookingStatus status;

    public Booking (Flight flight, Passenger passenger, Seat seat, double price) {
        this.id = UUID.randomUUID().toString();
        this.flight = flight;
        this.passenger = passenger;
        this.seat = seat;
        this.price = price;
        this.status = BookingStatus.CONFIRMED; // Default status
    }


    // GETTERS
    public String getId() {
        return id;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Seat getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
