public class jz13 {
    int m;
    int n;
    int k;
    int res;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        boolean[][] used = new boolean[m][n];
        dfs(0, 0, used);
        return res;
    }

    private void dfs(int i, int j, boolean[][] used) {
        if (!isValid(i, j) || used[i][j])
            return;
        res++;
        used[i][j] = true;
        dfs(i + 1, j, used);
        dfs(i, j + 1, used);
    }

    private boolean isValid(int i, int j) {
        boolean flag = i >= 0 && i < m && j >= 0 && j < n;
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum <= k && flag;
    }


    public static void main(String[] args) {
        jz13 jz13 = new jz13();
        System.out.println(jz13.movingCount(2, 3, 1));
    }
}
