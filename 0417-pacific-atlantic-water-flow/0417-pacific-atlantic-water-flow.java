class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            dfs(i, 0, pacific, heights);
        }
        for (int j = 0; j < m; j++) {
            dfs(0, j, pacific, heights);
        }

        for (int i = 0; i < n; i++) {
            dfs(i, m - 1, atlantic, heights);
        }
        for (int j = 0; j < m; j++) {
            dfs(n - 1, j, atlantic, heights);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int i, int j, boolean[][] ocean, int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        ocean[i][j] = true;

        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < 0 || x >= n || y < 0 || y >= m || ocean[x][y]) continue;
            if (heights[x][y] < heights[i][j]) continue;

            dfs(x, y, ocean, heights);
        }
    }
}
