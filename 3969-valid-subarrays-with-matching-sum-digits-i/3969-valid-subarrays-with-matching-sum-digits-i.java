class Solution {
    public int firstDigit(long n) {
        while (n >= 10) {
            n /= 10;
        }
        return (int)n;
    }
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        int res = 0;
        for(int i=0; i<n; i++){
            long sum = 0;
            for(int j = i; j<n; j++){
                sum += nums[j];
                if(sum%10 == x && firstDigit(sum)==x){
                    res++;
                }
            }
        }
        return res;
    }
}