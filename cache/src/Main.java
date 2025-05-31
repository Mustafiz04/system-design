import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final long DEFAULT_TTL = -1;
    public static void main(String[] args) throws InterruptedException {
        LRUCache<Integer, Integer> cache = new LRUCache<>(2);
        cache.add(1, 1); // cache = {1=1}
        cache.add(2, 2); // cache = {2=2, 1=1}
        System.out.println(cache.get(1)); // returns 1; cache = {1=1, 2=2}
        cache.add(3, 3); // evicts key 2; cache = {3=3, 1=1}
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.add(4, 4); // evicts key 1; cache = {4=4, 3=3}
        System.out.println(cache.get(1)); // returns -1
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4

        LRUCacheWithTTLDecorator<Integer, Integer> cacheTtl = new LRUCacheWithTTLDecorator<>(2);

        cacheTtl.add(1, 100, 1000); // TTL 1 second
        Thread.sleep(500);
        System.out.println(cacheTtl.get(1)); // Should print 100

        Thread.sleep(600);
        System.out.println(cacheTtl.get(1)); // Should return null (expired)
    }
}