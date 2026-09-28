class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int idx = 0;
        for(int i=0; i<nums.length; i++){
            if(idx < i) return false;
            idx  = Math.max(idx, i+nums[i]);
            if(idx>=nums.length-1) return true;
        }
        return false;
    }
}