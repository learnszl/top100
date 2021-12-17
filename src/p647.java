public class p647 {
    public int countSubstrings(String s) {
        int n = s.length(),res = 0;
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = (chars[i] == chars[j]) && (j - i < 2 || dp[i+1][j-1]);
                if(dp[i][j])
                    res++;
            }
        }
        return res;
    }

}
