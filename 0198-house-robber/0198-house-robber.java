class Solution {
    
    // public int f(int i, int n, int[] nums){
    //     if(i > n-1) return 0;;
        
    //     int rob = nums[i] + f(i+2, n, nums);
    //     int skip = f(i+1, n, nums);
    //     return Math.max(rob, skip);
    // }

    // public int f(int i, int n, int[] nums){
    //     if(i < 0) return 0;

    //     int rob = nums[i] + f(i-2, n, nums);
    //     int skip = f(i-1, n, nums);
    //     return Math.max(rob, skip);
    // }

    // memoization 
    // public int f(int i, int n, int[] nums, int[] dp){
    //     if(i < 0) return 0;
    //     if(dp[i] != -1) return dp[i];

    //     int rob = nums[i] + f(i-2, n, nums, dp);
    //     int skip = f(i-1, n, nums, dp);
    //     return dp[i] = Math.max(rob, skip);
    // }
    // public int rob(int[] nums) {
    //     int n = nums.length;
    //     int[] dp = new int[n+1];
    //     Arrays.fill(dp, -1);
    //     return f(n-1, n, nums, dp);
    // }

    // tabulation
    public int rob(int[] nums){
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++){
            int rob = dp[i-2] + nums[i];
            int skip = dp[i-1];
            dp[i] = Math.max(rob, skip);
        }

        return dp[n-1];
    }


}