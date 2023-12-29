import java.util.Comparator;

class LookScheduler implements ElevatorScheduler {
    private Direction direction;

    public LookScheduler(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Comparator<Request> getComparator() {
        if (direction == Direction.UP) {
            return Comparator.comparingInt(request -> request.floor);
        } else {
            return (request1, request2) -> Integer.compare(request2.floor, request1.floor);
        }
    }
}
