import java.util.Arrays;

public class p494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        int total = sum + target;
        if((target & 1) != 0)
            return  0;
        int half = total / 2;
        int[] dp = new int[half + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = half; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[half];
    }

    public static void main(String[] args) {
        p494 p494 = new p494();

        System.out.println(300000&1);
    }
}
