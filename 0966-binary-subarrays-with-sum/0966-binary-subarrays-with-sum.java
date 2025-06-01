class Solution {
    public int countSub(int[] nums, int goal){
        if(goal < 0) return 0;
        int l=0;
        int r=0;
        int n=nums.length;
        int count=0;
        int sum=0;
        while(r<n){
            int num = nums[r];
            sum+=num;
            while(sum > goal){
                sum-=nums[l];
                l++;
            }
            count += (r-l+1);
            r++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countSub(nums, goal) - countSub(nums, goal-1);
    }
}