package airlinemanagementsystem.seat;

public class Seat {
    private final String seatNumber;
    private final SeatStatus status;
    private final SeatType type;

    public Seat(String seatNumber, SeatType type) {
        this.seatNumber = seatNumber;
        this.type = type;
        this.status = SeatStatus.AVAILABLE;
    }

    // GETTER
    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public SeatType getType() {
        return type;
    }
}
