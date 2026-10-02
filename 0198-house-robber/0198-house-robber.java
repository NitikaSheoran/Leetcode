class Solution {
    public int f(int i, int[] nums, int[] dp){
        if(i>=nums.length) return 0;

        if(dp[i] != -1) return dp[i];
        int rob = nums[i] + f(i+2, nums, dp);
        int skip = f(i+1, nums, dp);

        return dp[i] = Math.max(rob, skip);
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+2];
        Arrays.fill(dp, -1);
        return f(0, nums, dp);
    }
}