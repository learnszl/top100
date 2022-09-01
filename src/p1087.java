import java.util.HashMap;
import java.util.List;

/**
 * @Author szl
 * @Date 2022/1/16 17:54
 * @Description
 */
public class p1087 {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> strings : knowledge) {
            map.put(strings.get(0), strings.get(1));
        }
        StringBuilder res = new StringBuilder();
        int l = -1;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l = i;
                flag = true;
            }
            if (s.charAt(i) == ')') {
                String str = s.substring(l + 1, i);
                if (map.containsKey(str)) {
                    res.append(map.get(str));
                } else
                    res.append('?');
                flag = false;
                continue;
            }
            if (!flag) {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
