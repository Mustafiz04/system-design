import java.util.Comparator;

class ScanScheduler implements ElevatorScheduler {
    @Override
    public Comparator<Request> getComparator() {
        // Scan algorithm sorts requests based on floor number
        return Comparator.comparingInt(request -> request.floor);
    }
}
