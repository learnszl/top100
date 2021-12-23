import java.util.Stack;

/**
 * @Author szl
 * @Date 2021/11/26 22:10
 * @Description
 */
public class jz63 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;
        int min = prices[0], res = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > min)
                res = Math.max(res, prices[i] - min);
            else
                min = prices[i];
        }
        return res;
    }
}
