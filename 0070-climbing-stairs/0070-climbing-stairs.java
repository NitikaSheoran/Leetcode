class Solution {
    // memoization

    // int[] dp;
    // public int climb(int n, int i, int[] dp){
    //     if(i == n){
    //         return 1;
    //     }
    //     if(i > n){
    //         return 0;
    //     }
    //     if(dp[i] != -1){
    //         return dp[i];
    //     }
    //     return dp[i] = climb(n, i+1, dp) + climb(n, i+2, dp);
    // }
    // public int climbStairs(int n) {
    //     dp = new int[n+1];
    //     Arrays.fill(dp, -1);
    //     return climb(n,0, dp);
    // }

    // tabulation
    public int climbStairs(int n) {
        int[] dp = new int[n+2];
        dp[n] = 1;
        dp[n+1] = 0;
        for(int i=n-1; i>=0; i--){
            dp[i] = dp[i+1] + dp[i+2];
        }
        return dp[0];
    }

}