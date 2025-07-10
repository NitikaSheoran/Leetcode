class Solution {
    public boolean f(int i, int target, int[] nums, Boolean[][] dp){
        if(target == 0) return true;
        if(i == 0) return nums[0]==target;


        if(dp[i][target] != null) return dp[i][target];

        boolean notTake = f(i-1, target, nums, dp);
        boolean take = false;
        if(nums[i] <= target){
            take = f(i-1, target-nums[i], nums, dp);
        }

        return dp[i][target] = take || notTake;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        int target = 0;
        if(sum%2 == 0){
            target = sum/2;
        }else{
            return false;
        }


        Boolean[][] dp = new Boolean[n][target+1];

        return f(n-1, target, nums, dp);
    }
}