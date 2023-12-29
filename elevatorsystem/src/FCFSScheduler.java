import java.util.Comparator;

class FCFSScheduler implements ElevatorScheduler {
    @Override
    public Comparator<Request> getComparator() {
        return Comparator.comparingInt(request -> request.floor);
    }
}
