

public class p312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloon = new int[n + 2];
        balloon[0] = 1;
        balloon[n + 1] = 1;
        System.arraycopy(nums, 0, balloon, 1, n);
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 3; len <= n + 2; len++) {
            for (int i = 0; i <= n + 2 - len; i++) {
                int res = 0;
                for (int k = i + 1; k < i + len - 1; k++) {
                    int left = dp[i][k];
                    int right = dp[k][i + len - 1];
                    res = Math.max(res, left + balloon[i] * balloon[k] * balloon[i + len - 1] + right);
                }
                dp[i][i + len - 1] = res;
            }
        }
        return dp[0][n + 1];
    }
}
