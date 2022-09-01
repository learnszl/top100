package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p46 {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, res, new ArrayList<>(), used);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> temp, boolean[] used) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1])
                continue;
            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;
                dfs(nums, res, temp, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int a1 = (ax2 - ax1) * (ay2 - ay1);
        int a2 = (bx2 - bx1) * (by2 - by1);
        int x = 0, y = 0;
        if (Math.min(ax2, bx2) <= Math.max(ax1, bx1))
            return a1 + a2;
        else {
            x = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        }
        if (Math.min(ay2, by2) <= Math.max(ay1, by1))
            return a1 + a2;
        else {
            y = Math.min(ay2, by2) - Math.max(ay1, by1);
        }
        return a1 + a2 - x * y;
    }

    public static void main(String[] args) {
        p46 p46 = new p46();
        System.out.println(p46.permute(new int[]{1, 1, 3}));
    }
}
