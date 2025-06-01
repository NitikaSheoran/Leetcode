class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int zero=0;
        int l=0; 
        int r=0;
        int maxLen=0;
        while(r<n){
            int num = nums[r];
            if(num==0) zero++;
            while(zero>k){
                if(nums[l]==0) zero--;
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}