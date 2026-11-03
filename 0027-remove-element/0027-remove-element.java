class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        if(nums.length == 1){
            if(nums[0] == val) return 0;
            return 1;
        }
        int l = 0;
        int r = nums.length-1;
        int count = 0;
        while(l<=r){
            while(l<r && r>=0 && nums[r] == val){
                count++;
                r--;
            }
            if(nums[l] == val){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                count++;
                r--;
            }
            l++;
            // r--;
        }
        return nums.length-count;
    }
}