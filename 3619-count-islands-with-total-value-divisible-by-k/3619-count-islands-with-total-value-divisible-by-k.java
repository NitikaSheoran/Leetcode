class Solution {
    long sum = 0;
    public void dfs(int i, int j, boolean[][] visited, int[][] grid){
        visited[i][j] = true;
        sum += grid[i][j];

        int[][] adjL = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] adj: adjL){
            int newI = i+adj[0];
            int newJ = j+adj[1];
            if(newI>=0 && newJ>=0 && newI<grid.length && newJ<grid[0].length && !visited[newI][newJ] && grid[newI][newJ]>0){
                dfs(newI, newJ, visited, grid);
            }
        }
    }
    
    public int countIslands(int[][] grid, int k) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] > 0){
                    sum = 0;
                    dfs(i, j, visited, grid);
                    if(sum%k == 0) count++;
                }
            }
        }
        return count;
    }
}