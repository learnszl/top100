import java.util.Stack;

/**
 * @Author szl
 * @Date 2021/12/23 11:04
 * @Description
 */
public class p234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        Stack<ListNode> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (slow.val != stack.pop().val)
                return false;
            slow = slow.next;
        }
        return true;
    }
}
