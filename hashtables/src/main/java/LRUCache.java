import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    /*
    12.3
    */

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
    }

    public Integer lookup(Integer key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        final Node node = cache.get(key);

        // Remove it from its current location
        delete(node);

        // Add it to the head as its the new least recently used
        addToHead(node);
        return node.value;
    }

    public void insert(Integer key, Integer value) {
        if (cache.containsKey(key)) {
            delete(cache.get(key));
        }

        final Node node = new Node(key, value);
        cache.put(key, node);
        addToHead(node);

        if (cache.size() > capacity) {
            int k = tail.prev.key;

            // Remove tail node
            delete(tail.prev);

            // Remove from map
            cache.remove(k);
        }
    }

    public void remove(Integer key) {
        if (cache.containsKey(key)) {
            final Node node = cache.get(key);
            cache.remove(key);
            delete(node);
        }
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
