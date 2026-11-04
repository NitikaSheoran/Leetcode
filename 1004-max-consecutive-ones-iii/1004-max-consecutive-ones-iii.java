class Solution {
    // max subarray with atmost 2 zeros
    public int longestOnes(int[] nums, int k) {
        int zeros = 0;
        int l=0;
        int r=0;
        int res = 0;
        while(r<nums.length){
            if(nums[r] == 0) zeros++;
            while(l<=r && zeros>k){
                if(nums[l] == 0) zeros--;
                l++;
            }
            res = Math.max(res, r-l+1);
            r++;
        }
        return res;
    }
}