import java.util.Arrays;

public class p34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};
        int l = 0, r = nums.length;
        int[] res = new int[2];
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        System.out.println(l);
        if (l != nums.length && nums[l] == target)
            res[0] = l;
        else
            return new int[]{-1, -1};
        l = 0;
        r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        res[1] = l - 1;
        return res;
    }


    public static void main(String[] args) {
        p34 p34 = new p34();
        System.out.println(Arrays.toString(p34.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 0)));
    }
}
