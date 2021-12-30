package knapsack;

public class p494 {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, sum = 0;
        for (int num : nums) {
            sum += num;
        }
        sum += target;
        if (sum % 2 != 0 || sum < 0)
            return 0;
        sum /=2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = sum; j >= num; j--)
                dp[j] += dp[j - num];
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        p494 p494 = new p494();
        System.out.println(p494.findTargetSumWays(new int[]{100},-200));
    }
}
