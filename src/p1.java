import java.util.*;

/**
 * @Author szl
 * @Date 2021/11/2 10:20
 * @Description
 */
public class p1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{i, map.get(target - nums[i])};
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    public int lengthOfLIS(int[] nums) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((int[] o1, int[] o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]));
        int n = nums.length, res = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int max_left = height[0];
        int max_right = height[n - 1];
        for (int i = 1; i < n; i++) {
            if (height[i] >= max_left) {
                left[i] = height[i];
                max_left = height[i];
            } else {
                left[i] = max_left;
            }
            if (height[n - i - 1] >= max_right) {
                right[n - i - 1] = height[n - i - 1];
                max_right = height[n - i - 1];
            } else {
                right[n - i - 1] = max_right;
            }
        }
        for (int i = 1; i < n - 1; i++) {
            res = res + Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int temp = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(temp, dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(temp, dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max(res, (r - l) * Math.min(height[l], height[r]));
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return res;
    }
//    List<List<Integer>> res;
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        res = new ArrayList<>();
//        dfs(candidates, target, new ArrayList<>(), 0);
//        return res;
//    }
//
//    private void dfs(int[] candidates, int target, ArrayList<Integer> temp, int index) {
//        if (target == 0) {
//            res.add(new ArrayList<>(temp));
//            return;
//        }
//        if (target < 0)
//            return;
//        for (int i = index; i < candidates.length; i++) {
//            temp.add(candidates[i]);
//            dfs(candidates, target - candidates[i], temp, i);
//            temp.remove(temp.size() - 1);
//        }
//    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] temp = new int[heights.length + 2];
        System.arraycopy(heights, 0, temp, 1, n);
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[i] < temp[stack.peek()]) {
                int curr = stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * temp[curr]);
            }
            stack.push(i);
        }
        return res;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            List<Integer> cur = new ArrayList<>();
            adj.add(cur);
        }
        for (int[] p : prerequisites) {
            in[p[0]]++;
            adj.get(p[1]).add(p[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : adj.get(pre)) {
                in[cur]--;
                if (in[cur] == 0)
                    queue.add(cur);
            }
        }
        return numCourses == 0;
    }

    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int begin = 0, end = 0, pos = 0, len = Integer.MAX_VALUE, count = t.length();
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map[c] > 0) {
                count--;
            }
            map[c]--;
            end++;
            while (count == 0) {
                if (end - begin < len) {
                    len = end - begin;
                    pos = begin;
                }
                if (map[s.charAt(begin)] == 0) {
                    count++;
                }
                map[s.charAt(begin)]++;
                begin++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(pos, pos + len);
    }


    public static void main(String[] args) {
        p1 p1 = new p1();
        System.out.println(p1.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//        System.out.println(p1.combinationSum(new int[]{2, 3, 6, 7}, 7));
//        System.out.println(p1.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
//        System.out.println(Arrays.toString(p1.twoSum(new int[]{3, 2, 4}, 6)));
//        System.out.println(p1.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
//        System.out.println(p1.minDistance("intention", "execution"));
//        int[] nums = new int[]{1,2,2,2,2,3,3};
//        int l = 0, r = nums.length - 1;
//        while (l < r) {
//            int mid = l + (r - l) / 2;
//            if (nums[mid] < 2) {
//                l = mid + 1;
//            }else{
//                r =mid;
//            }
//        }
//        System.out.println(l);
//        System.out.println(r);
    }
}
