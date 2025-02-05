class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount=0;
        int zeroIdx=-1;
        int mul = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeroCount++;
                zeroIdx=i;
            }
        }
        int[] res = new int[nums.length];
        if(zeroCount>=2){
            Arrays.fill(res,0);
        }else if(zeroCount==1){
            Arrays.fill(res,0);
            for(int i=0; i<nums.length; i++){
                if(i==zeroIdx) continue;
                mul *= nums[i];
            }
            res[zeroIdx]=mul;
        }else{
            int[] prefMul = new int[nums.length];
            int[] sufMul = new int[nums.length];
            prefMul[0]=1;
            sufMul[nums.length-1] = 1;
            for(int i=1; i<nums.length; i++){
                prefMul[i] = nums[i-1]*prefMul[i-1];
            }
            for(int i=nums.length-2; i>=0; i--){
                sufMul[i] = sufMul[i+1]*nums[i+1];
            }
            for(int i=0; i<nums.length; i++){
                res[i] = prefMul[i]*sufMul[i];
            }
        }
        return res;
    }
}