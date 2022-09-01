import java.util.Arrays;
import java.util.Random;

public class Sort {
    public int[] quickSort(int[] nums) {
        QuickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public int[] heapSort(int[] nums) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(nums, i, len);
        }
        for (int i = len - 1; i >= 0; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
        return nums;
    }

    public int[] mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, t = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        while (j <= right) {
            temp[t++] = nums[j++];
        }
        t = 0;
        while (left <= right) {
            nums[left++] = temp[t++];
        }
    }


    private void heapify(int[] nums, int i, int n) {
        int root = i, left = 2 * i + 1, right = 2 * i + 2;
        if (left < n && nums[left] > nums[root]) {
            root = left;
        }
        if (right < n && nums[right] > nums[root]) {
            root = right;
        }
        if (root != i) {
            swap(nums, root, i);
            heapify(nums, root, n);
        }
    }


    public void QuickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = partition(nums, l, r);
            QuickSort(nums, l, pos - 1);
            QuickSort(nums, pos + 1, r);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int pos = new Random().nextInt(r - l + 1) + l;
        swap(nums, pos, r);
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println((char) ('c' + 1));
        Sort sort = new Sort();
        System.out.println(Arrays.toString(sort.quickSort(new int[]{4, 2, 6, 26, 7, 278, 76, 43})));
        System.out.println(Arrays.toString(sort.heapSort(new int[]{4, 2, 6, 26, 7, 278, 76, 43})));
        System.out.println(Arrays.toString(sort.mergeSort(new int[]{4, 2, 6, 26, 7, 278, 76, 43})));
    }
}
