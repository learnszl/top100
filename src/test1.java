import java.util.ArrayList;
import java.util.List;

/**
 * @Author szl
 * @Date 2022/9/27 11:08
 * @Description // /**
 * 找到字符串中的所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * 示例 2:
 * <p>
 * 输入:
 * s: "abab" p: "ab"
 * <p>
 * 输出:
 * [0, 1, 2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * <p>
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class test1 {
    public List<Integer> fun(String s, String p) {
        int m = s.length(), n = p.length();
        List<Integer> res = new ArrayList<>();
        if (n > m)
            return res;
        int[] diffCount = new int[26];
        for (int i = 0; i < n; i++) {
            diffCount[s.charAt(i) - 'a']++;
            diffCount[p.charAt(i) - 'a']--;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (diffCount[i] != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            res.add(0);
        }
        for (int i = 0; i < m - n; i++) {
            int c = diffCount[s.charAt(i) - 'a'];
            if (c == 0) {
                diff++;
            } else if (c == 1) {
                diff--;
            }
            diffCount[s.charAt(i) - 'a']--;
            int c2 = diffCount[s.charAt(i + n) - 'a'];
            if (c2 == -1) {
                diff--;
            } else if (c2 == 0) {
                diff++;
            }
            diffCount[s.charAt(i + n) - 'a']++;
            if (diff == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        test1 test1 = new test1();
        System.out.println(test1.fun("abab","ab"));
    }
}
