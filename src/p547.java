/**
 * @Author szl
 * @Date 2022/2/13 21:59
 * @Description
 */
public class p547 {
    int[][] isConnected;
    int n;

    public int findCircleNum(int[][] isConnected) {
        this.isConnected = isConnected;
        n = isConnected.length;
        int res = 0;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(boolean[] isVisited, int i) {
        for (int j = 0; j < n; j++) {
            if (isConnected[i][j] == 1 && !isVisited[j]) {
                isVisited[j] = true;
                dfs(isVisited, j);
            }
        }
    }
}
