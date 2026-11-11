class Solution {
    public int peakValleyDifference(int[] nums) {
        int res=0;
        int n = nums.length;
        for(int i=1; i<n-1; i++){
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                res+=nums[i];
            }
            if(nums[i] < nums[i-1] && nums[i] < nums[i+1]){
                res-=nums[i];
            }

        }
        return res;
    }
}