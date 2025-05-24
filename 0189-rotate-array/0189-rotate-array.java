class Solution {
    public void reverse(int[] nums, int strt, int end){
        while(strt < end){
            int temp = nums[strt];
            nums[strt] = nums[end];
            nums[end] = temp; 
            strt++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
}