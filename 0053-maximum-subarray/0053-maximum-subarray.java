class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxS = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0; i<n; i++){
            sum += nums[i];
            maxS = Math.max(sum, maxS);
            if(sum<0) sum=0;
        }
        

        return maxS;
    }
}