class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;
        int temp = nums[0];
        int i=0;
        int j=0;
        int count=0;

        while(j<nums.length){
            while(j<nums.length && nums[j] == temp){
                j++;
                count++;
            }
            if(count>=2){
                nums[i] = temp;
                nums[i+1] = temp;
                i+=2;
            }else{
                for(int k=0; k<count; k++){
                    nums[i+k] = temp;
                }
                i+=count;
            }
            count = 0;
            if(j<nums.length){
                temp = nums[j];
            }
        }
        return i;
    }
}