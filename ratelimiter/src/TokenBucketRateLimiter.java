import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucketRateLimiter implements RateLimiter {
    private int capacity;
    private int refreshRate;
    private AtomicInteger currentCapacity;
    private AtomicLong lastUpdateTime;

    public TokenBucketRateLimiter(int capacity, int refreshRate) {
        this.capacity = capacity;
        this.refreshRate = refreshRate;
        this.currentCapacity.getAndSet(capacity);
        this.lastUpdateTime.getAndSet(System.currentTimeMillis());
    }

    @Override
    public boolean allowRequest() {
        refreshBucket();
        if( currentCapacity.get() > 0 ) {
            currentCapacity.decrementAndGet();
            return true;
        }
        return false;
    }

    void refreshBucket() {
        long currentTime = System.currentTimeMillis();
        int additionalToken = (int) ( (currentTime - lastUpdateTime.get()) /100 * refreshRate );
        int currCapacity = Math.min(currentCapacity.get() + additionalToken, capacity);
        currentCapacity.getAndSet(currCapacity);
        lastUpdateTime.getAndSet(currentTime);
    }
}
