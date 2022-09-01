import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author szl
 * @Date 2022/1/30 21:48
 * @Description
 */
public class p884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : s1.split(" ")) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String str : s2.split(" ")) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (String str : map.keySet()) {
            if (map.get(str) == 1)
                res.add(str);
        }
        return res.toArray(new String[0]);
    }
}
