public class p581 {
    public int findUnsortedSubarray(int[] nums) {
        int l = 0, r = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max)
                max = nums[i];
            else
                r = i;
            if (nums[nums.length - i - 1] <= min)
                min = nums[nums.length - i - 1];
            else
                l = nums.length - i - 1;
        }
        return l == r ? 0 : r - l + 1;
    }

    public static void main(String[] args) {
        p581 p581 = new p581();
        System.out.println(p581.findUnsortedSubarray(new int[]{2, 3, 3, 2, 4}));
    }
}
