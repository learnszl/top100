import java.math.BigInteger;

/**
 * @Author szl
 * @Date 2022/1/10 20:52
 * @Description
 */
public class p306 {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (dfs(num, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(String num, int i, int j) {
        if (num.charAt(0) == '0' && i > 1)
            return false;
        if (num.charAt(i) == '0' && j > 1)
            return false;
        long x1 = Long.parseLong(num.substring(0, i));
        long x2 = Long.parseLong(num.substring(i, i + j));
        String sum;
        for (int start = i + j; start < num.length(); start += sum.length()) {
            x2 = x1 + x2;
            x1 = x2 - x1;
            sum = String.valueOf(x2);
            if (!num.startsWith(sum, start))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        p306 p306 = new p306();
        System.out.println(p306.isAdditiveNumber("123"));
    }
}
