import java.util.Stack;

public class jz9 {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public jz9() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (!s2.isEmpty())
            return s2.pop();
        else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.isEmpty() ? -1 : s2.pop();
        }
    }
}
