class Solution {
    int m,n;
    void dfs(int i, int j, int[][]grid) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return;
        grid[i][j] = 0; 
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) dfs(i, 0, grid);
            if (grid[i][n - 1] == 1) dfs(i, n - 1, grid);
        }

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) dfs(0, j, grid);
            if (grid[m - 1][j] == 1) dfs(m - 1, j, grid);
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) count++;
            }
        }

        return count;
    }
}
