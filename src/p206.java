/**
 * @Author szl
 * @Date 2022/2/19 17:07
 * @Description
 */
public class p206 {
    public ListNode reverseList(ListNode head) {
        return helper(head, null);
//        if (head == null || head.next == null)
//            return head;
//        ListNode pre = null,curr = head;
//        while (curr != null){
//            ListNode next = curr.next;
//            curr.next = pre;
//            pre = curr;
//            curr = next;
//        }
//        return pre;
    }

    private ListNode helper(ListNode curr, ListNode pre) {
        if (curr == null)
            return pre;
        ListNode next = curr.next;
        curr.next = pre;
        return helper(next, curr);
    }
}
