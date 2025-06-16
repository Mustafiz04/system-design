package airlinemanagementsystem.flight;

import airlinemanagementsystem.Aircraft;

import java.time.LocalDateTime;

public class International extends Flight {
    public International(String source, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime, Aircraft aircraft) {
        super(source, destination, departureTime, arrivalTime, aircraft, FlightType.DOMESTIC);
    }
}
