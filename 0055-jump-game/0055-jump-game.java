class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int farthest = 0;
        for(int i=0; i<nums.length; i++){
            farthest = Math.max(farthest, i+nums[i]);
            if(farthest >= nums.length-1) return true;
            if(farthest <= i) return false; 
        }
        return true;
    }
}