package parking;
import java.time.*;

public class Ticket {
    private String ticketNumber;
    private String licensePlateNumber;
    private String allocatedSpotId;
    private LocalDateTime issuedAt;
    private LocalDateTime vacatedAt;
    private double charges;
    private TicketStatus ticketStatus;

    public Ticket(String ticketNumber, String licensePlateNumber, String allocatedSpotId, LocalDateTime issuedAt, LocalDateTime vacatedAt, double charges, TicketStatus ticketStatus) {
        this.ticketNumber = ticketNumber;
        this.licensePlateNumber = licensePlateNumber;
        this.allocatedSpotId = allocatedSpotId;
        this.issuedAt = issuedAt;
        this.vacatedAt = vacatedAt;
        this.charges = charges;
        this.ticketStatus = ticketStatus;
    }
}
