package knapsack;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class p416 {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= nums[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i - 1]] + 1);
            }
        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= target; j++) {
//                if (j >= nums[i-1])
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - nums[i-1]] + 1);
//                else
//                    dp[i][j] = dp[i - 1] [j];
//            }
//        }
        return dp[target] > 0;
    }

    public static void main(String[] args) {
        p416 p416 = new p416();
        System.out.println(p416.canPartition(new int[]{1, 5, 5, 11, 4}));
    }
}
