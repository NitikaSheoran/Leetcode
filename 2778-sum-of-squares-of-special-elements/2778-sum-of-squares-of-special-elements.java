class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int res = 0;
        for(int j=0; j<n; j++){
            if(n%(j+1) == 0){
                res = res+ nums[j]*nums[j];
                // System.out.println(res);
            }
        }
        return res;
    }
}