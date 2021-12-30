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

    public static void main(String[] args) {
        p46 p46 = new p46();
        System.out.println(p46.permute(new int[]{1, 1, 3}));
    }
}
