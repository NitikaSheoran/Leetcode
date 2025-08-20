class Solution {
    public void nextPermutation(int[] nums) {
        int breakpt = -1;
        int n = nums.length;
        for(int i=n-1; i>=1; i--){
            if(nums[i]>nums[i-1]){
                breakpt = i;
                break;
            }
        }
        // System.out.println("breakpt: "+ breakpt);
        if(breakpt == -1){
            Arrays.sort(nums);
            return;
        } 

        for(int i=n-1; i>=0; i--){
            if(nums[i]>nums[breakpt-1]){
                int temp = nums[i];
                nums[i] = nums[breakpt-1];
                nums[breakpt-1] = temp;
                break;
            }
        }
        // for(int num: nums) System.out.println(num);
        Arrays.sort(nums, breakpt, n);
    }
}