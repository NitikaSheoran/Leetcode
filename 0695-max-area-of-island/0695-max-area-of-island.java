class Solution {
    int area;
    public void dfs(int i, int j, boolean[][] visited, int[][] grid, int m, int n){
        visited[i][j] = true;
        area++;

        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int[] dir: dirs){
            int row = i+dir[0];
            int col = j+dir[1];
            if(row>=0 && row<n && col>=0 && col<m && !visited[row][col] && grid[row][col] == 1){
                dfs(row, col, visited, grid, m, n);
            }
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int res = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    area=0;
                    dfs(i, j, visited, grid, m, n);
                    res = Math.max(res, area);
                }
            }
        }

        return res;
    }
}
