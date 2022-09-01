package dfs;


public class p60 {
    int k;

    public String getPermutation(int n, int k) {
        StringBuffer res = new StringBuffer();
        this.k = k;
        dfs(n, res, new boolean[n]);
        return res.toString();
    }

    private void dfs(int n, StringBuffer res, boolean[] used) {
        if (res.length() == n) {
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i - 1])
                continue;
            if (k > helper(n - res.length() - 1)) {
                k -= helper(n - res.length() - 1);
                continue;
            }
            res.append(i);
            used[i - 1] = true;
            dfs(n, res, used);
//              sb.deleteCharAt(sb.length() - 1);
//              used[i - 1] = false;
//                return;
        }
    }

    private int helper(int n) {
        if (n == 0)
            return 1;
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }

    public static void main(String[] args) {
        p60 p60 = new p60();
        System.out.println(p60.getPermutation(3, 2));
    }
}
