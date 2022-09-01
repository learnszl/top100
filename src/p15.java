import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                continue;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1, r = n - 1;
            while (l < r) {
                int curr = nums[l] + nums[r] + nums[i];
                if (curr > 0)
                    r--;
                else if (curr < 0)
                    l++;
                else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    r--;
                    l++;
                    while (l < r && nums[l] == nums[l - 1])
                        l++;
                    while (l < r && nums[r] == nums[r + 1])
                        r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        p15 p15 = new p15();
        System.out.println(p15.threeSum(new int[]{0, 0, 0}));
    }
}
