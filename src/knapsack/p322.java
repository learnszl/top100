package knapsack;

import java.util.Arrays;

public class p322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = coins[i - 1]; j <= amount; j++) {
                if (dp[j - coins[i - 1]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        p322 p322 = new p322();
        System.out.println(p322.coinChange(new int[]{2}, 3));
    }
}
