import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SlidingWindow implements RateLimiter {
    private Queue<Long> slidingWindow;
    private int timeWindowInSecond;
    private int bucketCapacity;

    public SlidingWindow(int timeWindowInSecond, int bucketCapacity) {
        slidingWindow = new ConcurrentLinkedDeque<>();
        this.bucketCapacity = bucketCapacity;
        this.timeWindowInSecond = timeWindowInSecond;
    }

    @Override
    public boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        checkAndUpdateQueue(currentTime);
        if( slidingWindow.size() < bucketCapacity ) {
            slidingWindow.add(currentTime);
            return true;
        }
        return false;
    }

    private void checkAndUpdateQueue(long currentTime){
        if( slidingWindow.isEmpty() ) return;
        long timeDiff = (currentTime - slidingWindow.peek() ) /1000;
        while( timeDiff >= this.timeWindowInSecond ) {
            slidingWindow.poll();
            if( slidingWindow.isEmpty() ) break;
            timeDiff = (currentTime - slidingWindow.peek() ) /1000;
        }
    }
}
