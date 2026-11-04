class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = n-1;
        long res = 0;
        while(l<r){
            res += (long)nums[r]-nums[l];
            l++;
            r--;
        }
        return (int)res;
    }
}