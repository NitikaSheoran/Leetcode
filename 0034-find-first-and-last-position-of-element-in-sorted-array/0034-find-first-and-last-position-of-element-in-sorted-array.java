class Solution {
    public int fIdx(int[] nums, int target){
        int l = 0;
        int r = nums.length-1;
        int res = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                res = mid;
                r = mid-1;
            }else if(nums[mid]<target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return res;
    }
    public int rIdx(int[] nums, int target){
        int l = 0;
        int r = nums.length-1;

        int res = -1;

        while(l<=r){
            int mid = (l+r)/2;

            if(nums[mid] == target){
                res = mid;
                l = mid+1;
            }else if(nums[mid] > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return res;
    }
    public int[] searchRange(int[] nums, int target) {
        int l = fIdx(nums, target);
        int r = rIdx(nums, target);
        int[] res = new int[2];
        res[0] = l;
        res[1] = r;

        return res;
    }
}