class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l=0;
        int r = n-1;
        int res=-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                res= mid;
                return res;
            }else if(nums[mid]>=nums[l]){
                if(nums[l] <= target && nums[mid]>=target){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else if(nums[mid]<=nums[r]){
                if(nums[r]>=target && nums[mid+1]<=target){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }else{
                return -1;
            }
        }
        return -1;
    }
}