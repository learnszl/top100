package knapsack;

public class p474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int w0 = 0, w1 = 0;
            for (char c : str.toCharArray()) {
                if (c == '0')
                    w0++;
                else
                    w1++;
            }
            for (int j = m; j >= w0; j--) {
                for (int k = n; k >= w1; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - w0][k - w1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
