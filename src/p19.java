/**
 * @Author szl
 * @Date 2021/11/20 20:03
 * @Description
 */
public class p19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = head;
        int total = 0;
        while (p != null) {
            p = p.next;
            total++;
        }
        p = dummyHead;
        for (int i = 0; i < total - n; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        return dummyHead.next;
    }
}
