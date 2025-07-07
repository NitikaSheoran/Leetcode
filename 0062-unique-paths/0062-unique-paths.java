class Solution {
    // recursion
    // public int paths(int i, int j){
    //     if(i == 0 && j == 0) return 1;
    //     if(i<0 || j<0) return 0;
    //     int up = paths(i-1, j);
    //     int left = paths(i, j-1);
    //     return up+left;
    // }


    // memoization
    // public int paths(int i, int j, int[][] dp){
    //     if(i == 0 && j == 0) return 1;
    //     if(i<0 || j<0) return 0;

    //     if(dp[i][j] != -1) return dp[i][j];
    //     int up = paths(i-1, j, dp);
    //     int left = paths(i, j-1, dp);

    //     return dp[i][j] = up+left;
    // }


    public int uniquePaths(int m, int n) {
        // return paths(m-1, n-1);

        // int[][] dp = new int[m][n];
        // for(int i=0; i<m; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // dp[0][0] = 1;
        // paths(m-1, n-1, dp);
        // return dp[m-1][n-1];


        // tabulation
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j == 0) continue;
                int up = 0;
                int left = 0;
                if(i>=1) up = dp[i-1][j];
                if(j>=1) left = dp[i][j-1];

                dp[i][j] = up+left;
            }
        }
        return dp[m-1][n-1];
    }
}