import java.util.HashMap;
import java.util.Scanner;

public class test2 {
    static class ListNode {
        int key, value;
        ListNode pre;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }

    int cpa;
    ListNode head, tail;
    HashMap<Integer, ListNode> map;

    public test2(int capacity) {
        map = new HashMap<>();
        cpa = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.pre = null;
        head.next = tail;
        tail.pre = head;
        tail.next = null;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            deleteNode(node);
            moveNode(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            deleteNode(map.get(key));
            moveNode(map.get(key));
        } else {
            ListNode node = new ListNode(key, value);
            moveNode(node);
            map.put(key, node);
            if (map.size() > cpa) {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
            }
        }
    }

    public void deleteNode(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void moveNode(ListNode node) {
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextDouble()) {
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            System.out.println(2 * a * b / (a + b));
        }
//        test2 test2 = new test2(2);
//        test2.put(1, 1);
//        test2.put(2, 2);
//        System.out.println(test2.get(1));
//        test2.put(3, 3);
//        System.out.println(test2.get(2));
//        test2.put(4, 4);
//        System.out.println(test2.get(1));
//        System.out.println(test2.get(3));
//        System.out.println(test2.get(4));
    }
}
