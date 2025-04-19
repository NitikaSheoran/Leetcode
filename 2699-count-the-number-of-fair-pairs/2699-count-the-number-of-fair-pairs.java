class Solution {
    public long binaryS(int[] nums, int l, int r, int sum){
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] >= sum){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        long count=0;
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            long l = binaryS(nums, i+1, n-1, lower-nums[i]);
            long r = binaryS(nums, i+1, n-1, upper-nums[i]+1);
            count += (r-l);
        }
        return count;
    }
}