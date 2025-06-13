public class FlatRateFeeStrategy implements FeeStrategy {
    private static final double RATE_PER_HOUR = 10.0; // Flat rate fee

    @Override
    public double calculateFee(Ticket ticket) {
        long duration = ticket.getExitTime() - ticket.getIssueTime();
        long hour = (duration / (1000 * 60 * 60)) + 1; // Round up to the next hour
        return hour * RATE_PER_HOUR;
    }
}
