class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] == 0) zero++;
            else if(nums[i] == 1) one++;
            else two++;
        }
        int i=0;
        while(i<zero){
            nums[i] = 0;
            i++;
        }
        int count=0;
        while(count<one){
            nums[i]=1;
            i++;
            count++;
        }
        count=0;
        while(count<two){
            nums[i]=2;
            i++;
            count++;
        }
    }
}