class Solution {
    // recursion
    // public int f(int i, int n, int[] nums){
    //     if(i > n) return 0;
    //     int rob = nums[i] + f(i+2, n, nums);
    //     int skip = f(i+1, n, nums);
    //     return Math.max(rob, skip);
    // }

    // memoization
    public int f(int i, int n, int[] nums, int[] dp){
        if(i>n) return 0;
        if(dp[i] != -1) return dp[i];
        int rob = nums[i] + f(i+2, n, nums, dp);
        int skip = f(i+1, n, nums, dp);
        return dp[i] = Math.max(rob, skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 0) return 0;
        // return Math.max(f(0, n-2, nums), f(1, n-1, nums));

        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);

        return Math.max(f(0, n-2, nums, dp1), f(1, n-1, nums, dp2));
    }
}