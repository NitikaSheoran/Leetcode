class Solution {
    public int minimizeSum(int[] nums) {
        if(nums.length <= 2) return 0;

        int n = nums.length;
        Arrays.sort(nums);
        int s = nums[2];
        int e = nums[n-3];
        int res = Math.min(nums[n-2]-nums[1], Math.min(nums[n-1]-s, e-nums[0]));
        return res;
    }
}