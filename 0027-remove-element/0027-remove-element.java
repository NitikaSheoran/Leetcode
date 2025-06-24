class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        if(nums.length == 1 && nums[0] == val) return 0;
        int n = nums.length;
        int count = 0;

        int i=0;
        int j=0;
        while(j<n){
            while(j<n-1 && nums[j] == val){
                count++;
                j++;
            }
            nums[i] = nums[j];
            i++;
            j++;
        }
        if(nums[n-1] == val) count++;
        int res = n-count;
        return res;
    }
}