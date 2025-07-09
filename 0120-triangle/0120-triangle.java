class Solution {
    public int minSum(List<List<Integer>> triangle, int i, int j, int n, int m, int[][] dp){
        if(i == n-1){
            return triangle.get(i).get(j);
        }
        if(i>=n || j>=triangle.get(i).size()){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j] != -1) return dp[i][j];

        int down = minSum(triangle, i+1, j, n, m, dp);
        int right = minSum(triangle, i+1, j+1, n, m, dp);

        return dp[i][j] = triangle.get(i).get(j) + Math.min(down, right);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int[][] dp = new int[m][m];
        
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        dp[n-1][m-1] = triangle.get(m-1).get(n-1);
        minSum(triangle, 0, 0, m, n, dp);

        return dp[0][0];
    }
}