class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxI = 1;
        int maxD = 1;
        int l  = 0;
        
        while(l<nums.length){
            int num = nums[l];
            int count = 1;
            while(l<nums.length-1 && num<nums[l+1]){
                count++;
                l++;
                num = nums[l];
            }
            maxI = Math.max(maxI, count);
            l++;
        }
        l = 0;
        while(l<nums.length){
            int num = nums[l];
            int count = 1;
            while(l<nums.length-1 && num>nums[l+1]){
                count++;
                l++;
                num = nums[l];
            }
            maxD = Math.max(maxD, count);
            l++;
        }
        return Math.max(maxD, maxI);
    }
}