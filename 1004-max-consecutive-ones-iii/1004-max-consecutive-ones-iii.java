class Solution {
    // longest array with atmost k zeros
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        int count = 0;
        int len = 0;

        while(r<n){
            if(nums[r] == 0) count++;
            while(count > k && l<=r){
                if(nums[l] == 0) count--;
                l++;
            }

            len = Math.max(len, r-l+1);
            r++;
        }

        return len;
    }
}