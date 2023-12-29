public class Elevator {
    private int elevatorId;
    private int currentFloor;
    private Direction direction;
    private int maxFloor;


    Elevator() {
        currentFloor = 0;
        direction = Direction.IDLE;
    }

    Elevator(int elevatorId, int maxFloor) {
        this.elevatorId = elevatorId;
        this.currentFloor = 1;
        this.direction = Direction.UP;
        this.maxFloor = maxFloor;
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public void setElevatorId(int elevatorId) {
        this.elevatorId = elevatorId;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }
}
