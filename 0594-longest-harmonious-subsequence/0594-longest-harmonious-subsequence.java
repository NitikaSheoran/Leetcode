class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int l=0;
        int r=0;
        int n = nums.length;
        int maxlen = 0;
        while(l<=r && r<n){
            while(r<n && nums[r]-nums[l] <= 1){
                r++;
            }
            l++;
            if(nums[r-1] == nums[l-1]) continue;
            maxlen = Math.max(maxlen, r-l+1);
        }
        return maxlen;
    }
}