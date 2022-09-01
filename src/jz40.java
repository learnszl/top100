import java.util.Arrays;
import java.util.Random;

/**
 * @Author szl
 * @Date 2022/2/18 16:13
 * @Description
 */
public class jz40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        return quickSort(arr, 0, arr.length - 1, k);
    }

    public int[] getLeastNumbers1(int[] arr, int k) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
        for (int i = n - 1; i >= n - k; i--) {
            swap(arr,0,i);
            heapify(arr,0,i);
        }
//        return Arrays.copyOfRange(arr,n-k,n);
        return arr;

    }

    private void heapify(int[] arr, int i, int n) {
        int root = i;
        int left = (i << 1) + 1, right = (i << 1) + 2;
        if (left < n && arr[root] > arr[left])
            root = left;
        if (right < n && arr[root] > arr[right])
            root = right;
        if (root != i) {
            swap(arr, i, root);
            heapify(arr, root, n);
        }
    }

    private int[] quickSort(int[] arr, int l, int r, int k) {
        if (l <= r) {
            int pos = partition(arr, l, r);
            if (pos == k)
                return Arrays.copyOf(arr, k);
            return pos > k ? quickSort(arr, l, pos - 1, k) : quickSort(arr, pos + 1, r, k);
        } else
            return arr;
    }

    private int partition(int[] arr, int l, int r) {
        int pos = new Random().nextInt(r - l + 1) + l;
        swap(arr, pos, r);
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] < arr[r]) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, r);
        return i;
    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        jz40 jz40 = new jz40();
        System.out.println(Arrays.toString(jz40.getLeastNumbers(new int[]{0, 0, 2, 3, 2, 1, 1, 2, 0, 4}, 10)));
        System.out.println(Arrays.toString(jz40.getLeastNumbers1(new int[]{1,2,3}, 2)));
    }
}
