import java.util.*;

public class OnCallScheduler {
    private HashMap<String, List<int[]>> onCallShift = new HashMap<>();

    public void addSchedule(String name, int start, int end) {
        List<int[]> shift = onCallShift.getOrDefault(name, new ArrayList<>());
        shift.add(new int[]{start, end});
        onCallShift.put(name, shift);
    }

}
