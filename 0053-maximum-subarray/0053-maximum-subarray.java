class Solution {
    public int maxSubArray(int[] nums) {
        int max = 0;
        int res = nums[0];
        for(int i=0; i<nums.length; i++){
            max = Math.max(max+nums[i], nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}