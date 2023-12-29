public class DoublyLinkedList<T, E> {
    private Node<E> head = null;
    private Node<E> tail = null;


    public Node<E> addNode(E value) {
        Node<E> node = new Node<E>(value);
        if(head == null) {
            head = node;
            tail = node;
            return node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
            return node;
        }
    }

    public Node<E> removeLast() {
        if( head == null ) return null;
        if(head == tail) {
            head = tail = null;
            return null;
        }
        tail.prev.next = null;
        tail = tail.prev;
        return tail;
    }

    public void removeNode(Node<E> node) {
        if( node == tail ) {
            head = null;
            tail = null;
            return;
        } else if( node == head ) {
            node.next.prev = null;
            head = node.next;
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToFront(Node<E> node) {
        this.removeNode(node);
        this.addNode(node.value);
    }
}
