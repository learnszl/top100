import java.util.HashMap;

public class LRUCache {

    static class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode pre;
    }

    ListNode head, tail;
    int capacity;
    HashMap<Integer, ListNode> map;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.pre = null;
        tail.next = null;
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        moveToHead(map.get(key));
        return map.get(key).val;
    }

    public void put(int key, int value) {
        ListNode node = new ListNode();
        node.key = key;
        node.val = value;
        if (map.containsKey(key)) {
            deleteNode(map.get(key));
        }
        addNode(node);
        map.put(key, node);
        if (map.size() > capacity) {
            map.remove(tail.pre.key);
            deleteNode(tail.pre);
        }
        System.out.println(map);
    }

    private void moveToHead(ListNode node) {
        deleteNode(node);
        addNode(node);
    }

    private void deleteNode(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addNode(ListNode node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
    }
}
