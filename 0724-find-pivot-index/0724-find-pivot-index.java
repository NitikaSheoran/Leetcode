class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] lSum = new int[n];
        lSum[0] = 0;
        for(int i=1; i<n; i++){
            lSum[i] = lSum[i-1]+nums[i-1];
        }
        int[] rSum = new int[n];
        rSum[n-1] = 0;
        for(int i=n-2; i>=0; i--){
            rSum[i] = rSum[i+1]+nums[i+1];
        }
        for(int i=0; i<n; i++){
            if(lSum[i]==rSum[i]){
                return i;
            }
        }
        return -1;
    }
}