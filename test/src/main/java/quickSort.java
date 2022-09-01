import java.util.Arrays;
import java.util.Random;

/**
 * @Author szl
 * @Date 2022/3/7 14:25
 * @Description
 */
public class quickSort {
    public void quicksort(int[] nums) {
        helper(nums, 0, nums.length - 1);
    }

    private void helper(int[] nums, int l, int r) {
        if (l < r) {
            int pos = findPos(nums, l, r);
            helper(nums, l, pos - 1);
            helper(nums, pos + 1, r);
        }
    }

    private int findPos(int[] nums, int l, int r) {
        int pos = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, pos);
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] < nums[r]) {
                i++;
                swap(nums, i, j);
            }
        }
        i++;
        swap(nums, i, r);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        quickSort quickSort = new quickSort();
        int[] nums = {2,4536,236,3,3,2,7};
        int[] nums1 = {2,2,2,2,2,4,4,4,4,4};
        int[] nums2 = {235,34,56,10,1,5,3,7};
        int[] nums3 = {};
        quickSort.quicksort(nums);
        quickSort.quicksort(nums1);
        quickSort.quicksort(nums2);
        quickSort.quicksort(nums3);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));


    }
}
