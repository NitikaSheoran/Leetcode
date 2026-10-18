class Solution {
    public int minDeletions(int[] nums) {
        int res = 0;
        int i=0;
        int n = nums.length;
        while(i<n){
            int num = nums[i];
            int count = 0;
            while(i<n && nums[i] == num){
                count++;
                i++;
            }
            res += count-1;
        }
        return res;
    }
}