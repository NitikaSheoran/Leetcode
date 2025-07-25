class Solution {
    public int maximumCount(int[] nums) {
        int neg=0;
        int zero=0;
        int pos=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<0){
                neg++;
            }else if(nums[i]==0){
                zero++;
            }else{
                pos++;
            }
        }
        return Math.max(pos, neg);
    }
}