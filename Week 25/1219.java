class Solution {
    private int n, m;
    public int getMaximumGold(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ret = Math.max(ret, dfs(grid, i, j));
            }
        }
        return ret;
    }
    private int dfs(int[][] grid, int i, int j) {
        if (grid[i][j] == 0) return 0;
        int temp = grid[i][j], ret = 0;
        grid[i][j] = 0;
        if (i > 0) ret = Math.max(ret, dfs(grid, i - 1, j));
        if (i < n - 1) ret = Math.max(ret, dfs(grid, i + 1, j));
        if (j > 0) ret = Math.max(ret, dfs(grid, i, j - 1));
        if (j < m - 1) ret = Math.max(ret, dfs(grid, i, j + 1));
        grid[i][j] = temp;
        return ret + temp;
    }
}