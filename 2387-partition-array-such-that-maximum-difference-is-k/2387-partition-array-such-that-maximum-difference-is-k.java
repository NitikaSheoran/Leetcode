class Solution {
    public int partitionArray(int[] nums, int k) {
        int n=nums.length;
        int res=0;
        Arrays.sort(nums);
        int i=0;
        int j=0;
        while(j<n){
            while(j<n && nums[j]-nums[i] <= k){
                j++;
            }
            res++;
            i=j;
        }
        return res;
    }
}