/**
 * @Author szl
 * @Date 2021/11/20 21:30
 * @Description
 */
public class p21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {//迭代
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {    //递归
        return null;
    }
}
