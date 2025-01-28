class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int l = 0; 
        int n = nums.length;
        int r = n-1;
        int[] res = new int[2];
        
        int minStartIdx = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] >= target){
                minStartIdx = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        if(nums.length == 0 || minStartIdx == -1 || nums[minStartIdx]!=target){
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int maxLastIdx = -1;
        l=0;
        r=n-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] > target){
                r = mid-1;
            }else{
                maxLastIdx = mid;
                l = mid+1;
            }
        }
        
        res[0] = minStartIdx;
        res[1] = maxLastIdx;
        
        return res;
    }
}