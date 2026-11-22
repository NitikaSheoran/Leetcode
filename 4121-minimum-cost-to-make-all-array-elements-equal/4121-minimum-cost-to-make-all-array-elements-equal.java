class Solution {
    public int f(int i, int[] nums){
        int x = nums[i];
        while(i<nums.length && nums[i] == x){
            i++;
        }
        return i-1;
    }
    public int f2(int i, int[] nums){
        int x = nums[i];
        while(i>=0 && nums[i] == x){
            i--;
        }
        return i+1;
    }
    public long minCost(int[] nums) {
        long res = Long.MAX_VALUE;
        int n = nums.length;
        int i=1;
        while(i<n-1){
            int x = f(i, nums);
            int j = f2(i, nums);
            res = Math.min((long)j*nums[i] + (long)(n-x-1)*nums[x], res);
            i=x+1;
        }
        return res;
    }
}