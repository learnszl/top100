import java.util.HashMap;

public class LRUCache {
    static class LinkListNode {
        int key;
        int value;
        LinkListNode pre;
        LinkListNode next;
    }

    LinkListNode head, tail;
    int capacity;
    HashMap<Integer, LinkListNode> map;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new LinkListNode();
        head.pre = null;
        tail = new LinkListNode();
        tail.next = null;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        moveToHead(map.get(key));
        return map.get(key).value;
    }

    public void put(int key, int value) {
        LinkListNode node = new LinkListNode();
        node.key = key;
        node.value = value;
        if(map.containsKey(key)){
            removeNode(map.get(key));
        }
        map.put(key,node);
        addNode(node);
        if(map.size() > capacity){
            map.remove(tail.pre.key);
            removeNode(tail.pre);
        }

    }

    private void removeNode(LinkListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(LinkListNode node) {
        removeNode(node);
        addNode(node);
    }

    private void addNode(LinkListNode node) {
        node.next = head.next;
        head.next = node;
        node.next.pre = node;
        node.pre = head;
    }
}
