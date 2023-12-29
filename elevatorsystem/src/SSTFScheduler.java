import java.util.Comparator;

class SSTFScheduler implements ElevatorScheduler {
    private int currentFloor;

    public SSTFScheduler(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    @Override
    public Comparator<Request> getComparator() {
        return Comparator.comparingInt(request -> Math.abs(request.floor - currentFloor));
    }
}
