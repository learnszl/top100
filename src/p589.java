public class p589 {
    public int findUnsortedSubarray(int[] nums) {
        int left = 0, right = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max <= nums[i]) {
                max = nums[i];
            } else {
                right = i;
            }
            if (nums[nums.length - i - 1] <= min) {
                min = nums[nums.length - i - 1];
            } else {
                left = nums.length - i - 1;
            }
        }
        return left == right ? 0 : right - left + 1;
    }
}
