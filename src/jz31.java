import java.util.*;

/**
 * @Author szl
 * @Date 2022/1/7 22:25
 * @Description
 */
public class jz31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && i < popped.length && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
//        System.out.println(i);
        return i == popped.length;
    }

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        Random random = new Random();
        System.out.println(random.nextInt());
        jz31 jz31 = new jz31();
        System.out.println(jz31.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
}
