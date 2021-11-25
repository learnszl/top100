public class p34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                int first = mid, second = mid;
                for (int i = first; i > 0; i--) {
                    if (nums[i] == nums[i - 1])
                        first = i - 1;
                    else
                        break;
                }
                for (int i = second; i < nums.length - 2; i++) {
                    if (nums[i] == nums[i + 1])
                        second = i + 1;
                    else
                        break;
                }
                return new int[]{first, second};
            } else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return new int[]{-1, -1};
    }
}
