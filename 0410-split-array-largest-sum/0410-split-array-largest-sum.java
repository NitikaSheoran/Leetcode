class Solution {
    // public void f(int[] nums, int i, int cSum, int lSum, ArrayList<Integer> res){
    //     int maxS = Math.max(cSum, lSum);
    //     if(i == nums.length) return;
    //     if(maxS > res.get(0)){
    //         return;
    //     }
    //     res.add(0, Math.min(res.get(0), maxS));
    //     f(nums, i+1, cSum+nums[i], lSum-nums[i], res);
    // }
    
    public int splitArray(int[] nums, int k) {
        // int sum = 0;
        // int n = nums.length;
        // for(int i=0; i<n; i++){
        //     sum+=nums[i];
        // }
        // ArrayList<Integer> res = new ArrayList<>();
        // res.add(Integer.MAX_VALUE);
        // f(nums, 0, 0, sum, res);
        // return res.get(0);


        int sum=0;
        int maxNum = 0;
        for(int i=0; i<nums.length; i++){
            maxNum = Math.max(maxNum, nums[i]);
            sum += nums[i];
        }
        int l=maxNum;
        int r=sum;
        while(l<r){
            int mid = (l+r)/2;
            if(canSplit(nums, mid, k)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    public boolean canSplit(int[] nums, int sum, int k){
        int cSum = 0;
        int count=1;
        for(int i=0; i<nums.length; i++){
            if(cSum+nums[i] > sum){
                count++;
                cSum=0;
            }
            cSum+=nums[i];
        }
        return count<=k;
    }
}