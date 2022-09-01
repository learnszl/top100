import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author szl
 * @Date 2022/1/25 16:40
 * @Description
 */
public class jz45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (o1, o2) -> {
            long x1 = Long.parseLong(o1 + o2);
            long x2 = Long.parseLong(o2 + o1);
            return (int) (x1 - x2);
        });
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        jz45 jz45 = new jz45();
        System.out.println(jz45.minNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
