import java.util.HashMap;
import java.util.Map;

public class User {
    private Map<Integer, RateLimiter> bucket;

    public User(int id, RateLimiter rateLimiter) {
        bucket = new HashMap<>();
        bucket.put(id, rateLimiter);
    }

    public void accessApplication(int id) {
        if(bucket.get(id).allowRequest()) {
            System.out.println(Thread.currentThread().getName() + " Able to access the request");
        } else {
            System.out.println(Thread.currentThread().getName() + " 403: Too many request");
        }
    }
}
