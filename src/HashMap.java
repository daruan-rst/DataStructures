public class HashMap<K, V> {
    private int capacity; // initial capacity of the hash map
    private Node<K, V>[] buckets; // array of linked lists to store key-value pairs

    // constructor to initialize the hash map with given capacity
    public HashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new Node[capacity];
    }

    // helper class to represent a node in the linked list
    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // hash function to map keys to indices in the array
    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    // method to retrieve the value associated with a given key
    public V get(K key) {
        int index = hash(key);
        Node<K, V> current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // key not found
    }

    // method to insert or update a key-value pair
    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value; // update existing value
                return;
            }
            current = current.next;
        }
        // key not found, add new node to the beginning of the linked list
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    // method to remove a key-value pair from the hash map
    public void remove(K key) {
        int index = hash(key);
        Node<K, V> current = buckets[index];
        Node<K, V> previous = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    buckets[index] = current.next; // remove first node in list
                } else {
                    previous.next = current.next; // remove non-first node in list
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    // method to print the contents of the hash map
    public void print() {
        for (int i = 0; i < capacity; i++) {
            Node<K, V> current = buckets[i];
            while (current != null) {
                System.out.println(current.key + " : " + current.value);
                current = current.next;
            }
        }
    }
}
