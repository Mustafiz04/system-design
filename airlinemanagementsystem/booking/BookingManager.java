package airlinemanagementsystem.booking;

import airlinemanagementsystem.Passenger;
import airlinemanagementsystem.flight.Flight;
import airlinemanagementsystem.seat.Seat;

import java.util.*;

public class BookingManager {
    private static BookingManager instance;
    private final Map<String, Booking> bookings;

    public BookingManager() {
        this.bookings = new HashMap<>();
    }

    public static synchronized BookingManager getInstance() {
        if( instance == null ) {
            instance = new BookingManager();
        }
        return instance;
    }

    public Booking createBooking(Flight flight, Passenger passenger, Seat seat, double price) {
        Booking booking = new Booking(flight, passenger, seat, price);
        String bookingId = booking.getId();
        synchronized (bookingId) {
            bookings.put(bookingId, booking);
        }
        return booking;
    }

    public void cancelBooking(String bookingId) {
        synchronized (bookingId) {
            Booking booking = bookings.get(bookingId);
            if (booking != null) {
                booking.setStatus(BookingStatus.CANCELED);
                bookings.remove(bookingId);
            } else {
                throw new NoSuchElementException("Booking with ID " + bookingId + " does not exist.");
            }
        }
    }
}
