class Solution {
    public int countDominantElements(int[] nums) {
        int n = nums.length;
        if(n == 1) return n;
        int res = 0;
        if(nums[0] >= nums[1]) res++;
        for(int i=1; i<n-1; i++){
            if(nums[i] >= Math.ceil((double)(nums[i-1]+nums[i+1])/2)){
                res++;
            }
        }
        if(nums[n-1]>=nums[n-2]) res++;

        return res;
    }
}