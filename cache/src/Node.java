public class Node<E> {
    E value;
    Node next;
    Node prev;

    Node(E value) {
        this.value = value;
    }

    public E getValue() {
        return this.value;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public void setPrev(Node node) {
        this.prev = node;
    }
}
