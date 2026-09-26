class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;

        if(nums[0] > nums[1]) return 0;

        int l = 1;
        while(l<nums.length-1){
            if(nums[l] > nums[l-1] && nums[l] > nums[l+1]){
                return l;
            }
            l++;
        }
        if(nums[l] > nums[l-1]) return l;

        return -1;
    }
}