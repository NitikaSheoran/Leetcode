class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int res = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0; i<n; i++){
            sum = Math.max(nums[i], sum+nums[i]);
            res = Math.max(sum, res);
        }
        return res;
    }
}