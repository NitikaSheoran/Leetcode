class Solution {
    public boolean isCited(int mid, int[] nums){
        int count=0;
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i] >= mid) count++;
            if(count>=mid) return true;
        }
        return false;
    }
    public int hIndex(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = n;
        int res = 0;
        while(l<=r){
            int mid = (l+r)/2;
            if(isCited(mid, nums)){
                res = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return res;
    }
}