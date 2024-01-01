import java.lang.reflect.Executable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        RateLimiter leakyBucket = new LeakyBucket(10);
        RateLimiter slidingWindow = new SlidingWindow(1, 10);
        RateLimiter TokenBucketRateLimiter = new TokenBucketRateLimiter(10, 10);

        User user = new User(1, slidingWindow);
        ExecutorService executors = Executors.newFixedThreadPool(12);
        for(int i = 0; i<=12; i++) {
            executors.execute(() -> user.accessApplication(1));
        }
        executors.shutdown();
    }
}