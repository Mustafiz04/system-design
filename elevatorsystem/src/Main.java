// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = new ElevatorSystem(new SSTFScheduler(4));

        // Adding requests to the queue
        elevatorSystem.addRequest(new Request(5));
        elevatorSystem.addRequest(new Request(2));
        elevatorSystem.addRequest(new Request(8));
        elevatorSystem.addRequest(new Request(1));

        elevatorSystem.processRequests();

        // Process requests using FCFS algorithm
//        elevatorSystem.processRequests(new FCFSScheduler());

//         Process requests using SSTF algorithm
//        elevatorSystem.processRequests(new SSTFScheduler(4));

        // Process requests using Scan algorithm
//        elevatorSystem.processRequests(new ScanScheduler());
//
//        // Process requests using Look algorithm
//        elevatorSystem.processRequests(new LookScheduler(Direction.UP));
    }
}