package dfs;

import java.util.ArrayList;
import java.util.List;

public class p93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12)
            return res;
        dfs(s, 0, 4, new ArrayList<>(), res);
        return res;
    }

    private void dfs(String s, int start, int four, List<String> temp, List<String> res) {
        if (start == s.length()) {
            if (four == 0) {
                res.add(String.join(".", temp));
                return;
            }
        }
        for (int i = start; i <= start + 3; i++) {
            if (i > s.length())
                return;
            if (s.length() - i > 3 * four)
                return;
            if (isValid(s.substring(start, i))) {
                temp.add(s.substring(start, i));
                dfs(s, i, four - 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isValid(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum = sum * 10 + c - '0';
        }
        if (sum == 0)
            return s.length() == 1;
        if (sum > 0 && sum < 256) {
            return s.charAt(0) != '0';
        }
        return false;
    }

    public static void main(String[] args) {
        p93 p93 = new p93();
        System.out.println(p93.restoreIpAddresses("25025511135"));
    }
}
