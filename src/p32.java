import java.lang.annotation.Target;
import java.util.Stack;

public class p32 {
    public int longestValidParentheses(String s) {
        int n = s.length(), res = 0;
        char[] chars = s.toCharArray();
        int[] dp = new int[n + 1];
        for (int i = 1; i < n; i++) {
            if (chars[i] == '(') {
                dp[i] = 0;
            } else {
                if (chars[i - 1] == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else {
                    int index = i - dp[i - 1] - 1;
                    if (index >= 0 && chars[index] == '(')
                        dp[i] = dp[i - 1] + (index >= 1 ? dp[index - 1] : 0) + 2;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int longestValidParentheses1(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, (i - stack.peek()));
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        p32 p32 = new p32();
        System.out.println(p32.longestValidParentheses("(()())"));
    }
}
