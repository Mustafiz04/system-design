public class LRUCacheWithTTLDecorator<K, V> extends LRUCache<K, V> {
    LRUCacheWithTTLDecorator(int capacity) {
        super(capacity);
    }

    @Override
    public void add(K key, V value, long ttl) {
        if (map.containsKey(key)) {
            TTLNode<K, V> node = (TTLNode) map.get(key);
            node.setValue(value);
            node.setExpiryTime(System.currentTimeMillis() + ttl);
            moveToFront(node);
        } else {
            if (map.size() == capacity) {
                Node<K, V> lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node<K, V> newNode = new TTLNode<>(key, value, ttl);
            addToFront(newNode);
            map.put(key, newNode);
        }
    }

    @Override
    public V get(K key) {
        if (!map.containsKey(key)) {
            System.out.println("Node has not found: ");
            return null;
        }

        TTLNode<K, V> node = (TTLNode) map.get(key);
        if( node.isExpired() ) {
            System.out.println("Node has been expired: ");
            return null;
        }
        moveToFront(node);
        return node.getValue();
    }
}
