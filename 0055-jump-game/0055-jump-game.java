class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        int max = nums[0];
        if(max == 0) return false;
        for(int i=1; i<nums.length; i++){
            max = Math.max(max, i+nums[i]);
            if(max >= nums.length-1) return true;
            if(max<=i) return false;
           
        }
        return false;
    }
}