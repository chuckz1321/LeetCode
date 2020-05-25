package ByteDance;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-04-08
 */
public class moveCount {
    public int row = 0;
    public int col = 0;

    public int movingCount(int m, int n, int k) {
        row = m - 1 > k ? k : m;
        col = n - 1 > k ? k : n;
        boolean[][] visited = new boolean[row][col];
        return dfs(0, 0, 0, 0, visited, k);
    }

    private int dfs(int i, int j, int si, int sj, boolean[][] visited, int k) {
        if (i >= row || j >= col || visited[i][j] || k < si + sj) return 0;
        visited[i][j] = true;
        return 1
                + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj, visited, k)
                + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8, visited, k);
    }
}
