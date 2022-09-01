import java.util.Arrays;

/**
 * @Author szl
 * @Date 2022/3/20 16:39
 * @Description
 */
public class unionFind {
    private int[] fa;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        fa = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            fa[i] = i;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    int u = find(i + 1), v = find(j + 1);
                    if (u == v)
                        continue;
                    fa[u] = v;
                    res++;
                }
            }
        }
        System.out.println(Arrays.toString(fa));
        return res;
    }


    public int find(int x) {
        if (fa[x] != x)
            fa[x] = find(fa[x]);
        return fa[x];
    }

    public static void main(String[] args) {
        unionFind unionFind = new unionFind();
        System.out.println(unionFind.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }
}
