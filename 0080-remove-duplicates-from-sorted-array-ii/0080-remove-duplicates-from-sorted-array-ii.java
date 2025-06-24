class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;

        int i=0; 
        int j=0;
        int temp = nums[0];
        int count=0;
        while(j<n){
            while(j<n && nums[j] == temp){
                count++;
                j++;
            }
            if(count>=2){
                nums[i] = temp;
                nums[i+1] = temp;
                i=i+2;
            }else{
                for(int k=0; k<count; k++){
                    nums[i+k] = temp;
                    i++;
                }
            }
            count = 0;
            if(j<n) temp = nums[j];
        }
        return i;

    }
}