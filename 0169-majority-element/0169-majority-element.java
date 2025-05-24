class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int res;
        return nums[nums.length/2];
    }
}