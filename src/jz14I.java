import java.util.*;

public class jz14I {
    public int cuttingRope(int n) {
        if (n <= 3)
            return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0)
            return (int) Math.pow(3, a);
        if (b == 1)
            return 4 * (int) Math.pow(3, a - 1);
        else
            return 2 * (int) Math.pow(3, a);
    }
    public int lengthOfLongestSubstring(String s) {
        int res = 0,left = 0,right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
                right = i;
                res = Math.max(res,right - left +1);
            }else{
                map.put(s.charAt(i),i);
                left = i;
            }

        }
        return res;

    }


    public static void main(String [] args) {
//        int[][] arr = new int[0][0];
//        System.out.println(arr.length);
//        System.out.println(arr[0].length);
//        PriorityQueue<Integer> small = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2- o1;
//            }
//        });
//        PriorityQueue<Integer> big = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1- o2;
//            }
//        });
//        System.out.println(small.poll());
//        big.offer(small.poll());
        String s = "a,d,f,rr,e,rm4,4";
        System.out.println(Arrays.toString(s.split(",")));
        int i = 3, j = 3;
        System.out.println(i + j >>1);
        List<List<Integer>> res = new ArrayList<>();
        jz14I jz14I = new jz14I();
        System.out.println(jz14I.cuttingRope(10));
        System.out.println(6&2);
    }
}
