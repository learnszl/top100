package dfs;

import java.util.ArrayList;
import java.util.List;

public class p784 {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        dfs(arr, res, 0);
        return res;
    }

    private void dfs(char[] s, List<String> res, int index) {
        res.add(new String(s));
        for (int i = index; i < s.length; i++) {
            if (!(Character.isDigit(s[i]))) {
                char temp = s[i];
                if (Character.isLowerCase(s[i]))
                    s[i] = Character.toUpperCase(s[i]);
                else
                    s[i] = Character.toLowerCase(s[i]);
                dfs(s, res, i+1);
                s[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        p784 p784 = new p784();
        System.out.println(p784.letterCasePermutation("a1b2"));
    }
}
