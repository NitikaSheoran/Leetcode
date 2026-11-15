class Solution {
    // public int f(int i,int j, int sum, int[] arr){
    //     if(i>=arr.length) return 0;

    //     if(j >= arr.length){
    //         return f(i+1, i+1, 0, arr);
    //     }
    //     sum+=arr[j];
    //     int res = (sum%2==0)?0:1;
    //     return res + f(i, j+1, sum, arr);
        
    // }
    public int numOfSubarrays(int[] arr) {
        // return f(0, 0, 0, arr);
        int odd = 0;
        int even = 1;
        int res = 0;
        int n = arr.length;
        int r = 0;
        int sum = 0;
        int mod = 1_000_000_007;
        while(r<n){
            sum += arr[r];
            if(sum%2 == 0){
                res = (res+odd)%mod;
                even++;
            }else{
                res = (res+even)%mod;
                odd++;
            }
            r++;
        }
        return res;
    }
}