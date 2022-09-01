import java.util.Stack;

public class jz9 {
    Stack<Integer> a;
    Stack<Integer> b;

    public jz9() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void appendTail(int value) {
        a.push(value);
    }

    public int deleteHead() {
        if (b.isEmpty()) {
            if (a.isEmpty())
                return -1;
            else {
                while (!a.isEmpty())
                    b.push(a.pop());
            }
        }
        return b.pop();
    }

}
