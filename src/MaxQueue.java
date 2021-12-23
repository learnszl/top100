import java.util.ArrayDeque;
import java.util.Deque;

public class MaxQueue {
    Deque<Integer> a;
    Deque<Integer> b;

    public MaxQueue() {
        a = new ArrayDeque<>();
        b = new ArrayDeque<>();
    }

    public int max_value() {
        if (b.peekFirst() != null)
            return b.pollFirst();
        else
            return -1;
    }

    public void push_back(int value) {
        a.offerLast(value);
        while (!b.isEmpty() && value > b.peekLast()) {
            b.pollLast();
        }
        b.offerLast(value);
    }

    public int pop_front() {

        if (a.isEmpty()) {
            return -1;
        } else {
            if (a.peekFirst().equals(b.peekFirst())) {
                b.pollFirst();
            }
            return a.pollFirst();
        }
    }
}
