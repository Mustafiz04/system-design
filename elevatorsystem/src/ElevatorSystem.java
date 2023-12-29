import java.util.*;
public class ElevatorSystem {
    private PriorityQueue<Request> requestQueue;
    private Elevator elevator;
    private ElevatorScheduler scheduler;

    public ElevatorSystem(ElevatorScheduler scheduler) {
        this.scheduler = scheduler;
        this.requestQueue = new PriorityQueue<Request>((scheduler.getComparator()));
        this.elevator = new Elevator();
    }

    public void addRequest(Request request) {
        requestQueue.add(request);
    }

    public void processRequests() {
        while(true) {
            if( !requestQueue.isEmpty() ) {
                Request currReq = requestQueue.poll();
                moveElevator(currReq.floor);
            }
        }
//        Collections.sort(requestQueue, scheduler.getComparator());
//
//        for (Request request : requestQueue) {
//            moveElevator(request.floor);
//        }
//
//        // Clear the processed requests
//        requestQueue.clear();
    }

    private void moveElevator(int destinationFloor) {
        // Implement logic to move the elevator to the destination floor
        // Update the elevator's current floor and direction
        // Print the movement for demonstration purposes
        Direction newDirection = elevator.getCurrentFloor() < destinationFloor ? Direction.UP :
                elevator.getCurrentFloor() > destinationFloor ? Direction.DOWN : Direction.IDLE;

        // Update the elevator's current floor and direction
        elevator.setCurrentFloor(destinationFloor);
        elevator.setDirection(newDirection);

        // Print the movement details
        System.out.println("Elevator moved to floor " + destinationFloor +
                " in the direction " + newDirection);
    }
}
