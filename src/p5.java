

public class p5 {
    public String longestPalindrome(String s) {
        int[] pos = new int[2];
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 2; i <= len; i++) {
            for (int start = 0; start < len; start++) {
                int end = start + i - 1;
                if (end >= len)
                    break;
                if (end - start < 3)
                    dp[start][end] = chars[start] == chars[end];
                else
                    dp[start][end] = dp[start + 1][end - 1] && chars[start] == chars[end];
                if (dp[start][end] && (end - start) > (pos[1] - pos[0])) {
                    pos[0] = start;
                    pos[1] = end;
                }
            }
        }
//        System.out.println(pos[0]);
//        System.out.println(pos[1]);
        return s.substring(pos[0], pos[1] + 1);
    }


    public static void main(String[] args) {
        p5 p5 = new p5();
        System.out.println(p5.longestPalindrome("aaaa"));
    }
}
