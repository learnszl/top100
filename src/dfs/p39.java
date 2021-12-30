package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p39 {
    int[] candidates;
    int target;
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        dfs(0, new ArrayList<>(), used, 0);
        return res;
    }

    private void dfs(int sum, List<Integer> temp, boolean[] used, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (sum > target)
            return;
        for (int i = index; i < candidates.length; i++) {
            if(i > 0 && candidates[i] == candidates[i-1] && !used[i-1])
                continue;
            if (!used[i]) {
                used[i] = true;
                temp.add(candidates[i]);
                dfs(sum + candidates[i], temp, used, i);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        p39 p39 = new p39();
        System.out.println(p39.combinationSum(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
