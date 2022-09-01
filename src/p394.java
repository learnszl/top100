import java.util.Stack;

public class p394 {
    public String decodeString(String s) {
        int k = 0;
        StringBuilder res = new StringBuilder();
        Stack<Integer> digit = new Stack<>();
        Stack<StringBuilder> resStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                digit.push(k);
                resStack.push(res);
                k = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                int turn = digit.pop();
                for (int i = 0; i < turn; i++) {
                    temp.append(res);
                }
                res = resStack.pop().append(temp);

            } else if (c >= '0' && c <= '9') {
                k = c - '0' + k * 10;
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        p394 p394 = new p394();
        System.out.println(p394.decodeString("30[a2[c]]"));
    }
}

