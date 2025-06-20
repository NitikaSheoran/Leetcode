class Solution {
    int[] dp;
    public int climb(int n, int i, int[] dp){
        if(i == n){
            return 1;
        }
        if(i > n){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        return dp[i] = climb(n, i+1, dp) + climb(n, i+2, dp);
    }
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climb(n,0, dp);
    }
}