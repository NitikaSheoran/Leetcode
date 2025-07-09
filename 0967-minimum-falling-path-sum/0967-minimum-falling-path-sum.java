class Solution {
    // public int path(int i, int j, int n, int[][] matrix, int[][] dp){
    //     if(i>=n || i<0 || j>=n || j<0){
    //         return Integer.MAX_VALUE;
    //     }

    //     if(i == 0 && j>=0 && j<n){
    //         return matrix[i][j];
    //     }
    //     if(dp[i][j] != -1) return dp[i][j];

    //     int top = path(i-1, j, n, matrix, dp);
    //     int right = path(i-1, j+1, n, matrix, dp);
    //     int left = path(i-1, j-1, n, matrix, dp);
    //     return dp[i][j] = matrix[i][j] + Math.min(Math.min(top, right) , left);
    // }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int sum = Integer.MAX_VALUE;
        // for(int i=0; i<n; i++){
        //     sum = Math.min(path(n-1, i, n, matrix), sum);
        // }


        int[][] dp = new int[n][n];
        // for(int i=0; i<n; i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // for(int i=0; i<n; i++){
        //     sum = Math.min(path(n-1, i, n, matrix, dp), sum);
        // }


        for(int i=0; i<n; i++){
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = dp[i - 1][j];
                int left = j > 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int right = j < n - 1 ? dp[i - 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(left, right));
            }
        }

        for (int j = 0; j < n; j++) {
            sum = Math.min(sum, dp[n - 1][j]);
        }
        return sum;
    }
}