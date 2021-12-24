import java.util.HashMap;

public class p76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int begin = 0, end = 0, counter = map.size();
        int len = Integer.MAX_VALUE;
        int[] pos = new int[2];
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                    counter--;
            }
            end++;
            while (counter == 0) {
                if (end - begin < len) {
                    pos[0] = begin;
                    pos[1] = end;
                    len = end - begin;
                }
                char temp = s.charAt(begin);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    if (map.get(temp) > 0)
                        counter++;
                }
                begin++;
            }
        }
        return s.substring(pos[0], pos[1]);
    }

    public static void main(String[] args) {
        p76 mws = new p76();
        System.out.println(mws.minWindow("ADOBECODEBANC", "ABC"));
    }
}
