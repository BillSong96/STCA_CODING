class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] up = new int[n][m], down = new int[n][m], left = new int[n][m], right = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                left[i][j] = j == 0 ? (grid[i][j] == 1 ? 1 : 0) : (grid[i][j] == 1 ? 1 + left[i][j - 1] : 0);
                right[i][m - j - 1] = j == 0 ? (grid[i][m - j - 1] == 1 ? 1 : 0) : (grid[i][m - j - 1] == 1 ? 1 + right[i][m - j] : 0);
            }
        }
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                up[i][j] = i == 0 ? (grid[i][j] == 1 ? 1 : 0) : (grid[i][j] == 1 ? 1 + up[i - 1][j] : 0);
                down[n - i - 1][j] = i == 0 ? (grid[n - i - 1][j] == 1 ? 1 : 0) : (grid[n - i - 1][j] == 1 ? 1 + down[n - i][j] : 0);
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = Math.min(down[i][j], right[i][j]); k >= 1; k--) {
                    int i2 = i + k - 1, j2 = j + k - 1;
                    if (up[i2][j2] >= k && left[i2][j2] >= k) {
                        ret = Math.max(ret, k);
                        break;
                    }
                }
            }
        }
        return ret * ret;
    }
}