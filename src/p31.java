public class p31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int big = 0, small = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                big = i + 1;
                small = i;
                break;
            }
        }
        if (big == 0) {
            reverse(nums, 0, n - 1);
            return;
        }
        int ex = 0;
        for (int i = n - 1; i >= big; i--) {
            if (nums[i] > nums[small]) {
                ex = i;
                break;
            }
        }
        swap(nums, small, ex);
        reverse(nums, big, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
