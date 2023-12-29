public interface Cache<K, V> {
    public void add(K key, V value);
    public Node<V> get(K key);
    public void delete(K key);
}
