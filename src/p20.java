import java.util.HashMap;
import java.util.Stack;

/**
 * @Author szl
 * @Date 2021/11/20 21:16
 * @Description
 */
public class p20 {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0)
            return false;
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (isLeft(curr))
                stack.push(curr);
            else {
                if (stack.isEmpty() || stack.pop() != map.get(curr))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeft(char c) {
        return c == '[' || c == '{' || c == '(';
    }

    public static void main(String[] args) {
        p20 p20 = new p20();
        System.out.println(p20.isValid("()"));
    }
}
