import java.util.HashMap;

/**
 * @Author szl
 * @Date 2022/2/13 17:51
 * @Description
 */
public class p128 {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int cur = left + right + 1;
                map.put(num, cur);
                map.put(num - left, cur);
                map.put(num + right, cur);
                if (cur > res)
                    res = cur;
            }
        }
        return res;
    }
}
