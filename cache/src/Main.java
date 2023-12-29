// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Cache<String, String> lru = new LRUCache<>(10);
        lru.add("One", "1");
        lru.get("One");
    }
}