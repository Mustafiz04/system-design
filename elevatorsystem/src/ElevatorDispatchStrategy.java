import java.util.*;

public interface ElevatorDispatchStrategy {
    Elevator getBestElevator(List<Elevator> elevatorList, int requestFloor, Direction direction);

}
