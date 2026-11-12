class Solution {
    public long merge(int num1, int num2){
        long x=1;
        int temp = num2;
        while(num2!=0){
            num2 = num2/10;
            x = x*10;
        }
        long res = num1 * x + temp;
        return res;
        
    }
    public int minMergedInteger(int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i=0; i<n-1; i++){
            if(i%2 == 0){
                int merged = (int)merge(nums[i], nums[i+1]);
                res = Math.min(res, merged);
            }
        }
        return res;
    }
}