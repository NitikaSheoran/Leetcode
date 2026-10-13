class Solution {
    public long maxAlternatingSum(int[] nums) {
        long res = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
       
        int l = 0;
        int r = n-1;

        while(l<r){
            res = res + nums[r]*nums[r];
            res = res - nums[l]*nums[l];
            l++;
            r--;
        }
        if(n%2 == 1){
            res = res + nums[l]*nums[l];
        }
        return res;
    }
}