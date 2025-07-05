class Solution {
    
    public boolean dfs(int x, int y, int[][] grid, boolean[][] visited, int m, int n){
        if(x < 0 || x >= m || y < 0 || y >= n) return false;
        if(grid[x][y] == 1 || visited[x][y]) return true;

        visited[x][y] = true;
        boolean isClosed = true;

        for(int[] pair: new int[][]{
            {x+1, y},
            {x, y+1},
            {x-1, y},
            {x, y-1}
        }){
            int newX = pair[0];
            int newY = pair[1];
            
            isClosed = dfs(newX, newY, grid, visited, m, n) && isClosed;  
        }
        return isClosed;
    }
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int comp = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && grid[i][j] == 0){
                    if(dfs(i, j, grid, visited, m, n)) comp++;
                }
            }
        }
        return comp;
    }
}