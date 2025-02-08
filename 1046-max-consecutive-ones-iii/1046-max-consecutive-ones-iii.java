class Solution {
    public int longestOnes(int[] nums, int k) {
        // longest subarray with atmost k zeroes
        int l=0;
        int r=0;
        int n = nums.length;
        int maxLen = 0;
        int zeroes=0;
        while(r<n){
            if(nums[r]==0){
                zeroes++;
            }
            if(zeroes>k){
                int x = nums[l];
                if(x==0){
                    zeroes--;
                }
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}