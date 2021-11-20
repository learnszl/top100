import java.util.ArrayList;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/11/20 22:44
 * @Description
 */
public class p46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(res, new ArrayList<>(), nums, used);
        return res;
    }

    private void dfs(List<List<Integer>> res, ArrayList<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;
                dfs(res, temp, nums, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        p46 p46 = new p46();
        System.out.println(p46.permute(new int[]{1, 2, 3}));
    }
}
