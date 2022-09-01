import java.util.Arrays;

/**
 * @Author szl
 * @Date 2022/1/25 17:24
 * @Description
 */
public class jz60 {
    public double[] dicesProbability(int n) {
        int len = 6 * n - n + 1;
        double[] res = new double[len];
        int[][] count = new int[n + 1][n * 6 + 1];
        for (int i = 1; i <= 6; i++) {
            count[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i * 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j < k)
                        break;
                    count[i][j] += count[i - 1][j - k];
                }
            }
        }
//        System.out.println(Arrays.deepToString(count));
        int total = (int) Math.pow(6, n);
        for (int i = 0; i < len; i++) {
            res[i] = count[n][n + i] / (double) total;
//            res[len - i - 1] = res[i];
        }
        return res;
    }

    public static void main(String[] args) {
        jz60 jz60 = new jz60();
        System.out.println(Arrays.toString(jz60.dicesProbability(3)));
    }
}
