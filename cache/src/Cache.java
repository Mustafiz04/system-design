public interface Cache<K, V> {
    public void add(K key, V value);

    public V get(K key);

    public void delete(K key);

    default void add(K key, V value, long ttl) {
        add(key, value);
    }
}