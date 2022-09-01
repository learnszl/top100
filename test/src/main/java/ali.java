import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
//illegal length
//registration complete
//registration complete
//illegal charactor
//acount existed

public class ali {
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n > 0){
            int[] nums = new int[5];

            for (int i = 0; i < 5; i++) {
                nums[i] = in.nextInt();
            }
            System.out.println(ali.helper(nums));
            n--;
        }

    }

    private static void isValid(String s) {
        if (s.length() < 6 || s.length() > 12) {
            System.out.println("illegal length");
            return;
        }
        for (char c : s.toCharArray()) {
            if (!Character.isUpperCase(c) && !Character.isLowerCase(c)) {
                System.out.println("illegal charactor");
            }
        }
        if (set.contains(s)) {
            System.out.println("acount existed");
            return;
        }
        set.add(s);
        System.out.println("registration complete");
    }
    private static int helper(int[] nums){
        Arrays.sort(nums);
        if (nums[0] == 1 &&  nums[1] == 1){
            return 1;
        }
        int res = nums[1];
        Arrays.sort(nums);
        if (nums[2] - nums[1] > 0){
            res += Math.min(nums[0],nums[2] - nums[1]);
        }
        return res;
    }
}
