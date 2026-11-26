class Solution {
    public boolean isPrime(int num){
        if(num<2) return false;
        for(int i=2; i*i<=num; i++){
            if(num%i==0) return false;
        }
        return true;
    }
    public int minOperations(int[] nums) {
        int res = 0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(i%2 == 0){
                if(!isPrime(nums[i])){
                    int x = nums[i];
                    while(!isPrime(x)){
                        x++;
                    }
                    res += x-nums[i];
                }
            }else{
                if(isPrime(nums[i])){
                    int x = nums[i];
                    while(isPrime(x)){
                        x++;
                    }
                    res += x-nums[i];
                }
            }
        }
        return res;
    }
}