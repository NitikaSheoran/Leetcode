class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = 0;
        int min = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        int total = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            max = Math.max(nums[i], max+nums[i]);
            maxSum = Math.max(max, maxSum);

            min = Math.min(nums[i], min+nums[i]);
            minSum = Math.min(min, minSum);

            total+=nums[i];
        }

        if(maxSum < 0) return maxSum;

        return Math.max(maxSum, total-minSum);
    }
}