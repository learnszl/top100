import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author szl
 * @Date 2022/1/10 20:57
 * @Description
 */
public class p842 {
    public List<Integer> splitIntoFibonacci(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                List<Integer> res = new ArrayList<>();
                if (dfs(num, i, j, res))
                    return res;
            }
        }
        return new ArrayList<>();
    }

    private boolean dfs(String num, int i, int j, List<Integer> res) {
        if (i > 10 || j > 10)
            return false;
        if (num.charAt(0) == '0' && i > 1)
            return false;
        if (num.charAt(i) == '0' && j > 1)
            return false;
        long x1 = Long.parseLong(num.substring(0, i));
        long x2 = Long.parseLong(num.substring(i, i + j));
        if (x1 > Integer.MAX_VALUE || x2 > Integer.MAX_VALUE)
            return false;
        res.add((int) x1);
        res.add((int) x2);
        String sum;
        for (int start = i + j; start < num.length(); start += sum.length()) {
            x2 = x1 + x2;
            x1 = x2 - x1;
            if (x2 > Integer.MAX_VALUE)
                return false;
            res.add((int) x2);
            sum = String.valueOf(x2);
            if (!num.startsWith(sum, start))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        p842 p842 = new p842();
        System.out.println(p842.splitIntoFibonacci("74912134825162255812723932620170946950766784234934"));
    }
}
