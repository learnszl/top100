import java.util.Arrays;

public class p34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{};
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
        System.out.println(r);
        int left = nums[l] == target ? l : -1;

        if (left == -1)
            return new int[]{-1, -1};

        r = nums.length - 1;
        l = 0;
        while (l < r) {
            int mid = (l + r >> 1) + 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return new int[]{left, r};
    }

    public static void main(String[] args) {
        p34 p34 = new p34();
        System.out.println(Arrays.toString(p34.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 15)));
    }
}
