import java.util.ArrayList;
import java.util.Arrays;

public class p5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2)
            return s;
        int begin = 0, len = 1;
        char[] charArray = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (charArray[i] != charArray[j])
                    dp[i][j] = false;
                else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > len) {
                    begin = i;
                    len = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + len);
    }


    public static void main(String[] args) {
        final int[] a = {1,2,3};
        a[1] = 5;
        System.out.println(Arrays.toString(a));




        p5 p5 = new p5();
        System.out.println(p5.longestPalindrome("aaaa"));

    }
}
