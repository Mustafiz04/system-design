import java.util.Comparator;

public interface ElevatorScheduler {
    Comparator<Request> getComparator();
}
