import java.util.*;
public class ContainedNumbersFinder {
    private final HashSet<Integer> prevSet = new HashSet<>();

    public List<List<Integer>> findContainedNumbers(List<Integer> stream, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int n = stream.size();

        for(int i = 0; i<n; i+=k) {
            int end = Math.min(i + k, n);
            List<Integer> chunk = stream.subList(i, end);
            HashSet<Integer> currSet = new HashSet<>(chunk);

            List<Integer> remChunk = stream.subList(end, n);
            HashSet<Integer> nextSet = new HashSet<>(remChunk);

            List<Integer> contained = new ArrayList<>();
            for(int c: currSet) {
                if(!prevSet.contains(c) && !nextSet.contains(c)) {
                    contained.add(c);
                }
            }

            result.add(contained);
            prevSet.addAll(chunk);
        }

        return result;
    }
}
