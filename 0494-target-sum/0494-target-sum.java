class Solution {
    public int find(int i, int[] nums, int target, int sum){
        if(i < 0){
            if(sum == target){
                return 1;
            }
            else{
                return 0;
            }
        }
        
        int neg = find(i-1, nums, target, sum-nums[i]);
        int pos = find(i-1, nums, target, sum+nums[i]);
        

        return pos+neg;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length-1;
        return find(n, nums, target, 0);
    }
}