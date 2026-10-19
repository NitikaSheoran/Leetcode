class Solution {
    public int firstOcc(int[] nums, int target){
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int res = -1;
        while(l<=r){
            int mid = (l+r)/2;

            if(nums[mid] >= target){
                res = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        
        return res;
        
    }
    public int lastOcc(int[] nums, int target){
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int res = -1;
        while(l<=r){
            int mid = (l+r)/2;

            if(nums[mid] <= target){
                res = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        
        return res;
        
    }
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int fI = firstOcc(nums, target);
        if(fI == -1) return res;
        int lI = lastOcc(nums, target);
        if(fI == lI){
            res.add(fI);
            return res;
        }
        for(int i=fI; i<=lI; i++){
            res.add(i);
        }
        return res;
    }
}