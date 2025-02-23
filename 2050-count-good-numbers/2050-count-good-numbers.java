class Solution {
    long mod = (long)1e9 + 7;
    public long pow(long x, long n){
        if(n==0) return 1;
        long res = pow(x, n/2);
        if(n%2 == 0){
            res = res*res;
        }else{
            res = x*res*res;
        }
        return res % mod;
    }
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;
        int res = (int)((pow(5,even)*pow(4,odd))%mod);
        return res;
    }
}