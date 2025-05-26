class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int fIndex=-1;
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] >= target){
                fIndex=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        if(fIndex == -1 || nums[fIndex] != target){
            fIndex=-1;
        }
        l=0;
        r=nums.length-1;
        int lIndex=-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] <= target){
                lIndex=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        if(lIndex == -1 || nums[lIndex] != target){
            lIndex=-1;
        }
        res[0]=fIndex;
        res[1]=lIndex;
        return res;
    }
}