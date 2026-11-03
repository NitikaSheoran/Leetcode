class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;

        int i=0;
        
        int j=1;
        int count = 0;
        if(nums[0] != nums[1]){
            i=1;
            count++;
        }
        while(j<nums.length){
            while(j<nums.length-1 && nums[j] == nums[j+1]){
                j++;
            }
            nums[i] = nums[j];
            i++;
            j++;
            count++;
        }
        return count;
    }
}