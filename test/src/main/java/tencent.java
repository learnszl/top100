import java.util.*;

/**
 * @Author szl
 * @Date 2022/4/24 20:00
 * @Description
 */
public class tencent {
    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = Integer.parseInt(in.nextLine());
//        String s = in.nextLine();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = s.charAt(i) - '0';
//        }
//        System.out.println(Arrays.toString(nums));
//        System.out.println(tencent.q3(nums));
        System.out.println(tencent.getNumber(new int[]{3, 1, 1, 4, 5, 6}));
    }
//    private static int q5(int m,int[] nums){
//        int n = nums.length;
//        int[][] dp = new int[n + 1][n + 1];
//        dp[0][0] = m;
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <='' n; j++) {
//
//            }
//        }
//
//    }

    public static int getNumber(int[] a) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 2; i < 200000; i++) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                set.add(i);
        }
//        System.out.println(set);
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : a) {
            list.add(num);
        }
//        System.out.println(list.size());
        int len = list.size();
        ArrayList<Integer> cur = new ArrayList<>();
        while (len > 1) {
            int temp = 0;
            for (int i = 0; i < len; i++) {
                if (set.contains(i + 1)) {
                    cur.add(0,list.get(i));
                    temp++;
                }
            }
            len = temp;
            for (int i = 0; i < len; i++) {
                list.add(0, cur.get(i));
            }
        }
        return list.get(0);
    }

    private static int q3(int[] nums) {
        int n = nums.length;
        long attack = 0;
        long defense = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                defense = defense + i + 1;
            }
        }
        long res = defense;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                attack = attack + i + 1;
            } else {
                defense = defense - i - 1;
            }
            res = Math.min(res, Math.abs(defense - attack));
        }
        return (int) res;
    }

    public ListNode solve(ListNode[] a) {
        int res = Integer.MAX_VALUE;
        HashMap<Integer, ListNode> map = new HashMap<>();
        for (ListNode cur : a) {
            res = Math.min(res, cur.val);
            while (cur.next != null) {
                if (map.containsKey(cur.next.val)) {
                    cur.next = map.get(cur.next.val);
                }
                if (!map.containsKey(cur.val))
                    map.put(cur.val, cur);
            }
        }
        ListNode p = a[0];
        while (p.next.val != res) {
            p = p.next;
        }
        ListNode head = p.next;
        p.next = null;
        return head;
        // write code here
    }

    private static void q1(int[] nums) {
        //        Scanner in = new Scanner(System.in);
//        int n = Integer.parseInt(in.nextLine());
//        String s = in.nextLine();
//        int len = s.length();
//        int[][] nums = new int[n][len];
//        for (int i = 0; i < len; i++) {
//            nums[0][i] = s.charAt(i) - '0';
//        }
//        for (int i = 1; i < n; i++) {
//            String temp = in.nextLine();
//            for (int j = 0; j < len; j++) {
//                nums[i][j] = temp.charAt(j) - '0';
//            }
//        }
////        System.out.println(Arrays.deepToString(nums));
//        int[] res = new int[len];
//        Arrays.fill(res, 0);
//        for (int i = 0; i < len; i++) {
//            int k = 10;
//            boolean flag = true;
//            for (int j = 0; j < n; j++) {
//                if (nums[j][i] == 0 && flag) {
//                    continue;
//                } else {
//                    res[i] = res[i] * k + nums[j][i];
//                    flag = false;
//                }
//            }
////            System.out.println(res[i]);
//        }
//        Arrays.sort(res);
//        for (int i = 0; i < len - 1; i++) {
//            System.out.print(res[i] + " ");
//        }
//        System.out.println(res[len - 1]);
    }
}
