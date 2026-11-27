class Solution {
    public long f(int i, int[] nums, int[] colors, long[] dp){
        if(i == nums.length) return 0;
        if(dp[i] != -1) return dp[i];

        boolean canRob = (i+1 == nums.length || colors[i] != colors[i+1]);
        if(canRob){
            return dp[i] = nums[i]+f(i+1, nums, colors, dp);
        }
        return dp[i] = Math.max(nums[i]+f(i+2, nums, colors, dp), f(i+1, nums, colors, dp));
    }
    public long rob(int[] nums, int[] colors) {
        long[] dp = new long [nums.length];
        Arrays.fill(dp, -1);
        return f(0, nums, colors, dp);
    }
}