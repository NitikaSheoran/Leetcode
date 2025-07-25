class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int l=0;
        int n = nums.length;
        int r=n-1;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]>nums[mid+1]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;

    }
}