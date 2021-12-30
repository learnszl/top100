import java.util.PriorityQueue;

public class p239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            heap.offer(new int[]{nums[i], i});
        }
        res[0] = heap.peek()[0];
        for (int i = k; i < n; i++) {
            heap.offer(new int[]{nums[i], i});
            while (heap.peek()[1] <= i - k)
                heap.poll();
            res[i - k + 1] = heap.peek()[0];
        }
        return res;
    }
}
