class Solution {
    public int[] productExceptSelf(int[] nums) {
        long prod = 1;
        int n = nums.length;
        int zero = 0;
        int idx = -1;
        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                zero++;
                idx = i;
            }
            else prod = prod*nums[i];
        }
        int[] res = new int[n];
        Arrays.fill(res, 0);
        if(zero>1) return res;
        if(zero == 1){
            res[idx] = (int)prod;
            return res;
        }
        for(int i=0; i<n; i++){
            res[i] = (int)prod/nums[i];
        }
        return res;
    }
}