class Solution {
    public int numOfSubarrays(int[] arr) {
        int count=0;
        int sum=0;
        int odd=0;
        int even = 1;
        int r=0;
        int mod = 1_000_000_007;
        while(r<arr.length){
            sum += arr[r];
            if(sum%2 == 0){
                count = (count + odd)%mod;
                even++;
            }else{
                count = (count + even)%mod;
                odd++;
            }
            r++;
        }
        return count;
    }
}