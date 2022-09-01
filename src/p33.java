public class p33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[left] < nums[mid]) {
                if (target > nums[mid] && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target > nums[mid] && target > nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    int res = 0;

    public int fun(int num) {
        String s = String.valueOf(num);
        dfs(s, 0, s.length());
        return res;
    }

    private void dfs(String s, int index, int n) {
        if (index >= n - 1) {
            res++;
            return;
        }
        if (index < n - 1 && (s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index + 1) < '6')) {
            dfs(s, index + 2, n);
        }
        dfs(s, index + 1, n);
    }

    public static void main(String[] args) {
        p33 p33 = new p33();
        System.out.println(p33.fun(18580));
    }
}
