class Solution {
    public long minCost(int[] nums) {
        long res = 0;
        int n = nums.length;
        res += (long)nums[0];
        res += (long)nums[n-1];

        long even = 0;
        long odd = Long.MAX_VALUE;
        // min sum of even number of elements elements
        for(int i=1; i<n-1; i++){
            long newEven = Math.min(even, odd==Long.MAX_VALUE? Long.MAX_VALUE: odd+nums[i]);
            long newOdd = Math.min(odd, even+nums[i]);
            even = newEven;
            odd = newOdd;
        }
        res += even;
        return res;
    }
}