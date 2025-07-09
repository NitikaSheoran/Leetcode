class Solution {

    // memo
    // public int minSum(List<List<Integer>> triangle, int i, int j, int n, int m, int[][] dp){
    //     if(i == n-1){
    //         return triangle.get(i).get(j);
    //     }
    //     if(i>=n || j>=triangle.get(i).size()){
    //         return Integer.MAX_VALUE;
    //     }

    //     if(dp[i][j] != -1) return dp[i][j];

    //     int down = minSum(triangle, i+1, j, n, m, dp);
    //     int right = minSum(triangle, i+1, j+1, n, m, dp);

    //     return dp[i][j] = triangle.get(i).get(j) + Math.min(down, right);
    // }
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] dp = new int[m][m];
        
        // for(int i=0; i<m; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        dp[m-1][n-1] = triangle.get(m-1).get(n-1);
        // minSum(triangle, 0, 0, m, n, dp);

        for (int j = 0; j < triangle.get(m - 1).size(); j++) {
            dp[m - 1][j] = triangle.get(m - 1).get(j);
        }
        for(int i=m-2; i>=0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                if(i == m-1 && j == n-1) continue;
                int down = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                if(i<m-1) down = Math.min(dp[i+1][j], down);
                if(j<n-1 && i<m-1) left = Math.min(dp[i+1][j+1], left);

                dp[i][j] = triangle.get(i).get(j) + Math.min(down, left);
            }
        }

        return dp[0][0];
    }
}