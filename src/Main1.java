import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s0 = scanner.nextLine().split(" ");
        int n = Integer.parseInt(s0[0]);
        int k = Integer.parseInt(s0[1]);
        String[] s = scanner.nextLine().split(" ");
        int[] weight = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(s[i]);
            sum += weight[i];
        }
        Arrays.sort(weight);
        int res = n;
        while (res > 0) {
            double a = sum / (double) res;
            if ((double) weight[res - 1] <= a * k) {
                System.out.println(res);
                break;
            }
//            System.out.println(a);
            sum -= weight[res - 1];
            res--;
        }
    }
//
}
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = Integer.parseInt(scanner.nextLine());
//        String[] left = scanner.nextLine().split(" ");
//        String[] right = scanner.nextLine().split(" ");
//        String[] target = scanner.nextLine().split(" ");
//        int[] nums = new int[70001];
//        for (int i = 0; i < 70001; i++) {
//            if (nums[i] != 0)
//                continue;
//            String s = String.valueOf(i);
//            int res = s.charAt(0) - '0';
//            for (int j = 1; j < s.length(); j++) {
//                res ^= (s.charAt(j) - '0');
//            }
//            if (i < 7000) {
//                for (int j = 0; j < 9; j++) {
//                    int tmp = res;
//                    tmp ^= j;
//                    nums[i * 10 + j] = tmp;
//                }
//            }
//            nums[i] = res;
//        }
//        for (int i = 0; i < n; i++) {
//            int l = Integer.parseInt(left[i]);
//            int r = Integer.parseInt(right[i]);
//            int t = Integer.parseInt(target[i]);
//            int res = 0;
//            for (int j = l; j <= r; j++) {
//                if (nums[j] == t) {
//                    res++;
//                }
//            }
//            System.out.print(res + " ");
//        }
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] s = scanner.nextLine().split(" ");
//        int n = Integer.parseInt(s[0]);
//        int m = Integer.parseInt(s[1]);
//        long k = Long.parseLong(s[2]);
//        String[] strings = scanner.nextLine().split(" ");
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(Integer.parseInt(strings[i]));
//        }
//        for (int i = 0; i < n; i++) {
//            list.add(Integer.parseInt(strings[n - i - 1]));
//        }
//        int size = 2 * n;
//        while (k > size) {
//            k = k - size;
//        }
//        System.out.println(list.get((int) k - 1));
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] nums = new int[n];
//        int pos = 0, neg = 0, zero = 0, max = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            nums[i] = scanner.nextInt();
//            if (nums[i] > 0) {
//                pos++;
//            } else if (nums[i] < 0) {
//                neg++;
//            } else {
//                zero++;
//            }
//            max = Math.max(max, Math.abs(nums[i]));
//        }
//        long res = 0;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] < 0) {
//                res = -nums[i] - 1 + res;
//            } else if (nums[i] > 0) {
//                res = nums[i] - 1 + res;
//            } else {
//                res++;
//            }
//        }
//        if (max >= 7) {
//            res -= 6;
//        } else {
//            res = res - (max - 1) + 7 - max;
//        }
//        if (neg % 2 == 0) {
//            System.out.println(res);
//        } else {
//            if (zero == 0)
//                System.out.println(res + 2);
//            else
//                System.out.println(res);
//        }
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] s = scanner.nextLine().split(" ");
//        int n = Integer.parseInt(s[0]);
//        int m = Integer.parseInt(s[1]);
//        long k = Long.parseLong(s[2]);
//        String[] strings = scanner.nextLine().split(" ");
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(Integer.parseInt(strings[i]));
//        }
//        for (int i = 0; i < n; i++) {
//            list.add(Integer.parseInt(strings[n - i - 1]));
//        }
//        int size = 2 * n;
//        if (k > size) {
//            k = k - size;
//        }
//        System.out.println(list.get((int) k - 1));
//    }
