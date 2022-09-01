
//import java.util.Scanner;
//
//public class Main1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] s = sc.nextLine().split(" ");
//        System.out.println(helper(s[0],s[1]));
//    }
//
//    private static int helper(String s1, String s2) {
//        int a = Integer.parseInt(s1);
//        int b = Integer.parseInt(s2);
//        if (a % b == 0 || b % a == 0)
//            return 0;
//        return -1;
//    }
//}
// 本题为考试多行输入输出规范示例，无需提交，不计分。
//import java.util.Scanner;
//
//public class Main1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        int n = s.length();
//        if (n % 2 != 0) {
//            int re = 0, j = 0;
//            String rede = "rede";
//            for (int i = 0; i < n; i++) {
//                if (s.charAt(i) != rede.charAt(j)) {
//                    re++;
//                    j = (j + 1) % 4;
//                }
//            }
//            int de = 0, k = 0;
//            String dere = "dere";
//            for (int i = 0; i < n; i++) {
//                if (s.charAt(i) != dere.charAt(k)) {
//                    de++;
//                    k = (k + 1) % 4;
//                }
//            }
//            System.out.println(Math.min(de, re));
//        } else {
//
//
//        }
//    }
//}
import test.Main;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = new int[n];
        String[] s = sc.nextLine().split(" ");
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
            set.add(nums[i]);

        }
        int res = 0;
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int in :set) {
            int[] fre = new int[n];
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1) {
                    fre[j] = nums[j] == in ? 1 : 0;
                } else {
                    fre[j] = nums[j] == in? fre[j + 1] + 1 : fre[j + 1];
                }
            }
            map.put(in,fre);
        }
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < cur) {
                    res += map.get(cur)[j];
                }
            }
        }
        System.out.println(res);
    }
}
//    import java.util.Scanner;
//
//    public class Main1 {
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            int n = Integer.parseInt(sc.nextLine());
//            int[] nums = new int[n];
//            String[] s = sc.nextLine().split(" ");
//            int maxadd = 1,maxeven = 1;
//            int addsum = 0,evensum = 0;
//            long sum = 0;
//            for (int i = 0; i < n; i++) {
//                nums[i] = Integer.parseInt(s[i]);
//                if (i % 2 == 0 && nums[i] > maxadd){
//                    maxadd = nums[i];
//                }
//                if (i % 2 != 0 && nums[i] > maxeven){
//                    maxeven = nums[i];
//                }
//                sum += nums[i];
//            }
//            if (maxadd == maxeven){
//                for (int i = 0; i < n; i++) {
//                    if (i % 2 == 0 && maxadd == nums[i]){
//                        addsum++;
//                    }
//                    if (i % 2 !=0 && maxeven == nums[i]){
//                        evensum++;
//                    }
//                }
//                if (addsum > evensum){
//                    maxeven++;
//                }else{
//                    maxadd++;
//                }
//            }
//            long total = 0;
//            for (int i = 0; i < n; i++) {
//                if (i % 2 == 0){
//                    total += maxadd;
//                }else{
//                    total += maxeven;
//                }
//            }
//
//            System.out.println(total - sum);
//        }
//    }
