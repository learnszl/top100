package test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = Integer.parseInt(str);
        int[][] nums = new int[n][n + 1];
        int[] res = new int[n];
        int i = 0;
        while (i < n) {
            String s = scanner.nextLine();
            int k = 0;
            for (String s1 : s.split(" ")) {
                nums[i][k++] = Integer.parseInt(s1);
            }
            i++;
        }
        for (int j = 0; j < n; j++) {
            if (nums[j][1] == 0)
                res[j] = nums[j][0];
        }
        for (int j = 0; j < n; j++) {
            int max = 0;
            if (nums[j][1] != 0) {
                for (int k = 0; k < nums[j][1]; k++) {
                    if (res[nums[j][k + 2] - 1] > max) {
                        max = res[nums[j][k + 2] - 1];
                    }
                }
            }
            res[j] = max + nums[j][0];
        }
        for (int j = 0; j < n - 1; j++) {
            System.out.print(res[j] + " ");
        }
        System.out.println(res[n - 1]);
    }



}
//
//    private static boolean isValid(int[] nums, int target) {
//        int n = nums.length;
//        int[] dp = new int[target + 1];
//        Arrays.fill(dp, Integer.MIN_VALUE);
//        dp[0] = 0;
//        for (int i = 1; i <= n; i++) {
//            for (int j = target; j >= nums[i - 1]; j--) {
//                dp[j] = Math.max(dp[j], dp[j - nums[i - 1]] + 1);
//            }
//        }
//        return dp[target] > 0;
//    }
//
//
//    private static int helper(int[] nums) {
//        int n = nums.length;
//        int len = 3;
//        int res = 0;
//        for (int num : nums) {
//            res += num;
//        }
//        while (len <= n) {
//            for (int i = 0; i <= n - len; i++) {
//                PriorityQueue<Integer> heap = new PriorityQueue<>();
//                for (int j = i; j < len + i; j++) {
//                    heap.offer(nums[j]);
//                }
//                int k = 0;
//                while (k < len / 2) {
//                    heap.poll();
//                    k++;
//                }
//                res += heap.peek();
//            }
//            len += 2;
//        }
//        return res;
//    }
//}
