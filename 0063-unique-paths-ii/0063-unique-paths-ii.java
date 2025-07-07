class Solution {
    // public int path(int i, int j, int[][] obs){
    //     if(i == 0 && j == 0) return 1;
    //     if(i<0 || j<0) return 0;
    //     if(obs[i][j] == 1)  return 0;

    //     int up = path(i-1, j, obs);
    //     int left = path(i, j-1, obs);

    //     return up+left;
    // }

    // memo
    // public int path(int i, int j, int[][] obs, int[][] dp){
    //     if(i == 0 && j == 0) return 1;
    //     if(i<0 || j<0) return 0;
    //     if(obs[i][j] == 1) return 0;

    //     if(dp[i][j] != -1) return dp[i][j];

    //     int up = path(i-1, j, obs, dp);
    //     int left = path(i, j-1, obs, dp);

    //     return dp[i][j] = up+ left;
    // }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        // return path(m-1, n-1, obstacleGrid);
        

        // int[][] dp = new int[m][n];
        // for(int i=0; i<m; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // dp[0][0] = 1;
        // path(m-1, n-1, obstacleGrid, dp);
        // return dp[m-1][n-1] == -1? 0: dp[m-1][n-1];

        // tabulation
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0) continue;
                int up=0;
                int left=0;
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    if(i>=1) up = dp[i-1][j];
                    if(j>=1) left = dp[i][j-1];
                    dp[i][j] = up+left;
                }
            }
        }
        return dp[m-1][n-1] == -1? 0: dp[m-1][n-1];
    }
}