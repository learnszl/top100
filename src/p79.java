public class p79 {
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, used, i, j, m, n, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] used, int i, int j, int m, int n, int len) {
        if (len == word.length() - 1) {
            return board[i][j] == word.charAt(len);
        }
        if (board[i][j] == word.charAt(len)) {
            used[i][j] = true;
            for (int[] d : dir) {
                int x = i + d[0];
                int y = j + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !used[x][y]) {
                    if (dfs(board, word, used, x, y, m, n, len + 1))
                        return true;
                }
            }
            used[i][j] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        p79 p79 = new p79();
        System.out.println(p79.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }
}
