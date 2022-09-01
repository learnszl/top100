import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author szl
 * @Date 2022/4/16 15:05
 * @Description
 */
public class wangyi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] nums = new int[n];
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            nums[i] = in.nextInt();
//        }
//        for (int i = 0; i < n; i++) {
//            int temp = nums[i];
//            for (int j = i; j < n; j++) {
//                if (i == j) {
//                    res += transfer(nums[i]);
//                } else {
//                    temp *= nums[j];
//                    res += transfer(temp);
//                }
//            }
//        }
//        System.out.println(res);
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        int x = Integer.parseInt(s1[1]);
        int[] res = helper(n, k, x);
        if (res.length == 0)
            System.out.println(-1);
        else {
            for (int i = 0; i < res.length - 1; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.print(res[res.length - 1]);
        }
    }

    private static int transfer(int n) {
        String s = String.valueOf(n);
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0')
                res++;
            else
                break;
        }
        return res;
    }


    private static int[] helper(int n, int k, int x) {
        return new int[0];
    }


    private void test1() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int len = n * 2;
        char[][] res = new char[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(res[i], '*');
        }
        int j = n;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < j; k++) {
                res[i][k] = '.';
            }
            j--;
        }
        for (int i = n; i < 2 * n; i++) {
            for (int k = n; k < 2 * n; k++) {
                res[i][k] = '.';
            }
        }
        char[][] ans = new char[2 * len][2 * len];
        for (int i = 0; i < len; i++) {
            for (int k = 0; k < len; k++) {
                ans[i][k] = res[i][k];
            }
            for (int k = len; k < 2 * len; k++) {
                ans[i][k] = res[i][2 * len - 1 - k];
            }
        }
        for (int i = len; i < 2 * len; i++) {
            for (int k = 0; k < len; k++) {
                ans[i][k] = res[2 * len - 1 - i][k];
            }
            for (int k = len; k < 2 * len; k++) {
                ans[i][k] = res[2 * len - 1 - i][2 * len - 1 - k];
            }
        }
        for (int i = 0; i < 2 * len; i++) {
            for (int k = 0; k < 2 * len; k++) {
                System.out.print(ans[i][k]);
            }
            System.out.print('\n');
        }
    }
}
