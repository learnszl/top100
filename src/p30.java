import java.util.HashMap;
import java.util.List;

public class p30 {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String ss : words) {
            map.put(ss, map.getOrDefault(ss, 0) + 1);
        }
        int counter = map.size(), begin = 0, end = 0, res = 0;
        while (end < s.length()) {
            String temp = s.substring(begin, end);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) - 1);
                if (map.get(temp) == 0) {
                    counter--;
                }
                begin = end;
            }
            end++;
            while (counter == 0){

            }
        }
    }
}
