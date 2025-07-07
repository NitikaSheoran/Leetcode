class Solution {

    // recursion
    // public int path(int i, int j, int[][] grid){
    //     if(i == 0 && j == 0){
    //         return grid[0][0];
    //     }
    //     if(i<0 || j<0) return Integer.MAX_VALUE;

    //     int up = path(i-1, j, grid);
    //     int left = path(i, j-1, grid);

    //     return grid[i][j] + Math.min(up, left);
    // }

    // memo
    public int path(int i, int j, int[][]grid, int[][] dp){
        if(i == 0 && j == 0) return grid[0][0];
        if(i<0 || j<0) return Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];

        int up = path(i-1, j, grid, dp);
        int left = path(i, j-1, grid, dp);

        return dp[i][j] = grid[i][j] + Math.min(up, left);
    }


    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // return path(m-1, n-1, grid);

        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = grid[0][0];
        path(m-1, n-1, grid, dp);
        return dp[m-1][n-1];
    }
}