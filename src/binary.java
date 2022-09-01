/**
 * @Author szl
 * @Date 2022/4/29 16:09
 * @Description
 */
public class binary {
    public static void main(String[] args) {
        System.out.println(binary.binary_search(new int[]{0, 1, 2, 3, 4, 5, 6}, 0));
    }

    public static int binary_search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
