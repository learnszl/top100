package knapsack;

import java.util.Arrays;

public class p322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = coins[i - 1]; j <= amount; j++) {
                if (dp[j] - 1 > dp[j - coins[i - 1]])
                    dp[j] = 1 + dp[j - coins[i - 1]];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        p322 p322 = new p322();
        System.out.println(p322.coinChange(new int[]{1, 2, 5}, 11));
    }
}
