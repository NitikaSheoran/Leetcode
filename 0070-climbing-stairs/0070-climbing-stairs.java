class Solution {
    public int f(int idx, int[] dp){
        if(idx == 0) return 1;
        if(idx < 0) return 0;

        if(dp[idx] != -1) return dp[idx];

        return dp[idx] = f(idx-1, dp) + f(idx-2, dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return f(n, dp);
    }
}