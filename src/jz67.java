import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author szl
 * @Date 2021/11/26 22:25
 * @Description
 */
public class jz67 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1)
            return nums;
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0] - o2[0] : o2[1] - o1[1];
            }
        });
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            heap.offer(new int[]{i, nums[i]});
        }
        res[0] = heap.peek()[1];
        for (int i = k; i < n; i++) {
            heap.offer(new int[]{i, nums[i]});
            while (heap.peek()[0] <= i - k) {
                heap.poll();
            }
            res[i - k + 1] = heap.peek()[1];
        }
        return res;
    }

    public int strToInt(String str) {
        String s = str.trim();
        boolean positive = true;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0) {
                if (c == '-')
                    positive = false;
                else if (c == '+') {
                } else if (Character.isDigit(c)) {
                    res = c - '0';
                } else {
                    return 0;
                }
            } else {
                if (Character.isDigit(c)) {
                    res = res * 10 + c - '0';
                } else
                    return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b -a);
        heap.offer(1);
        heap.offer(2);
        heap.offer(15);
        heap.offer(3453);
        System.out.println(heap.peek());


    }
}
