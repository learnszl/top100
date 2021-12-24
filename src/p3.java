import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.PriorityQueue;

public class p3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0, res = 0;
        while (end < s.length()) {
            if (map.containsKey(s.charAt(end))) {
                begin = Math.max(begin, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);
            res = Math.max(res, end - begin + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> objects = new PriorityQueue<>((a,b)->a-b);
        p3 p3 = new p3();
        System.out.println(p3.lengthOfLongestSubstring("abcabcbb"));
    }
}
