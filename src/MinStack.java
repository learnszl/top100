import java.util.Stack;

public class MinStack {
    Stack<Integer> a;
    Stack<Integer> b;

    public MinStack() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int val) {
        a.push(val);
        if (b.isEmpty() || val < b.peek())
            b.push(val);
    }

    public void pop() {
        if(a.pop().equals(b.peek()))
            b.pop();
    }

    public int top() {
        return a.peek();
    }

    public int getMin() {
        return b.peek();
    }
}
