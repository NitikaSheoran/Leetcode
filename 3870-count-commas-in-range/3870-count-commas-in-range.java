class Solution {
    public int countCommas(int n) {
        if(n<1000) return 0;
        int res = 0;
        for(int a=1000; a<=n; a++){
            res+=1;
        }
        return res;
    }
}