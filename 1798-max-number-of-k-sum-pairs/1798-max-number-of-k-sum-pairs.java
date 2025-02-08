class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int ptr1 = 0, ptr2 = nums.length - 1, count = 0;
        
        while(ptr1 < ptr2){
            int sum = nums[ptr1] + nums[ptr2];
            if(sum == k){
                count++;
                ptr1++;
                ptr2--;
            }
            else if(sum < k) ptr1++;
            else ptr2--;
        }
        return count;
    }
}