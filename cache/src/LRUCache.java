import java.util.HashMap;

public class LRUCache<K, V> implements Cache<K, V>{
    private HashMap<K, Node<V>> map;
    private DoublyLinkedList<K, V> dll;
    private int maxSize = 100;
    Node head = null;

    LRUCache(int size) {
        if(size > 0) this.maxSize = size;
        map = new HashMap<K, Node<V>>();
        dll = new DoublyLinkedList<>();
    }

    @Override
    public void add(K key, V value) {
        Node<V> node = new Node<>(value);
        map.put(key, node);
        dll.addNode(value);
    }

    @Override
    public Node<V> get(K key) {
        if( map.containsKey(key) ) {
            Node<V> node = map.get(key);
            dll.moveToFront(node);
            return node;
        }
        return null;
    }

    @Override
    public void delete(K key) {
        if(!map.containsKey(key)) {
            System.out.println("Key " + key + " is not present.");
            return;
        }
        map.remove(key);
        dll.removeNode(map.get(key));
    }
}
