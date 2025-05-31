import java.util.HashMap;

public class LRUCache<K, V> implements Cache<K, V>{
    protected final HashMap<K, Node<K, V>> map;
    protected int capacity = 100;
    Node<K, V> head, tail = null;

    LRUCache(int size) {
        if(size > 0) this.capacity = size;
        map = new HashMap<K, Node<K, V>>();

        // Dummy head and tail
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public void add(K key, V value) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            node.setValue(value);
            moveToFront(node);
        } else {
            if (map.size() == capacity) {
                Node<K, V> lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node<K, V> newNode = new Node<>(key, value);
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

        Node<K, V> node = map.get(key);
        moveToFront(node);
        return node.getValue();
    }

    @Override
    public void delete(K key) {
        if(!map.containsKey(key)) {
            System.out.println("Key " + key + " is not present.");
            return;
        }
        map.remove(key);
    }

    // Helper methods
    protected void moveToFront(Node<K, V> node) {
        remove(node);
        addToFront(node);
    }

    protected void addToFront(Node<K, V> node) {
        node.setNext(head.next);
        node.setPrev(head);

        head.getNext().setPrev(node);
        head.setNext(node);
    }

    protected void remove(Node<K, V> node) {
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
    }
}
