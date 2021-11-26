public class jz13 {
    int k, m, n;

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        this.k = k;
        this.m = m;
        this.n = n;
        return dfs(visited,0,0);
    }

    private int dfs(boolean[][] visited, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j])
            return 0;
        if (count(i) + count(j) > k)
            return 0;
        visited[i][j] = true;
        return 1 + dfs(visited, i - 1, j) + dfs(visited, i + 1, j) + dfs(visited, i, j + 1) + dfs(visited, i, j - 1);
    }

    private int count(int i) {
        int res = 0;
        while (i != 0) {
            res += i % 10;
            i /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        jz13 jz13 = new jz13();
        System.out.println(jz13.movingCount(2,3,1));
    }
}
