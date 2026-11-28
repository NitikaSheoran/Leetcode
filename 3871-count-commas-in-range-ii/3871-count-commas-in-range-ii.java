class Solution {
    public long countCommas(long n) {
        long x = 1000;
        long res = 0;
        while(x<=n){
            res = res + n-x+1;
            x = x*1000;
        }
        return res;
    }
}