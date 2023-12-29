import java.util.List;

public class FirstComeFirstServeAlgorithm implements ElevatorDispatchStrategy {

    @Override
    public Elevator getBestElevator(List<Elevator> elevatorList, int requestFloor, Direction direction) {
        for (Elevator elevator : elevatorList) {
            if (elevator.getDirection() == Direction.IDLE) {
                return elevator; // Return the first idle elevator if available
            }
        }
        return null; // If no idle elevators, return null
    }
}
