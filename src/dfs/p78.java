package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p78 {
    List<List<Integer>> res;
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        this.nums = nums;
        boolean[] used = new boolean[nums.length];
        dfs(0, new ArrayList<>(), used);
        return res;
    }

    private void dfs(int index, List<Integer> temp, boolean[] used) {
        res.add(new ArrayList<>(temp));
        if (temp.size() > nums.length)
            return;
        for (int i = index; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1])
                continue;
            if (!used[i]) {
                used[i] = true;
                temp.add(nums[i]);
                dfs(i, temp, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        p78 p78 = new p78();
        System.out.println(p78.subsets(new int[]{1, 2, 2}));
    }
}
