import java.util.NoSuchElementException;

public class LinkedList {

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst(int data) {
        head = new Node(data, head);
        size++;
    }

    public void addLast(int data) {
        if (head == null) {
            addFirst(data);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data, null);
            size++;
        }
    }

    public int removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public int size() {
        return size;
    }
}