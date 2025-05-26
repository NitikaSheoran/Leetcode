class Solution {
    public int DivSum(int mid, int[] nums){
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += Math.ceil((double)nums[i]/mid);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int l=1;
        int r=0;
        for(int i=0; i<nums.length; i++){
            r = Math.max(r, nums[i]);
        }
        while(l<=r){
            int mid = (l+r)/2;
            int sum = DivSum(mid, nums);
            if(sum > threshold){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return l;
    }
}