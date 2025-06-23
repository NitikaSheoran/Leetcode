class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        if(x==1 || x == 2 || x==3) return 1;
        int l=2; int r=x;
        int ans=1;
        while(l<=r){
            int mid =  l + (r - l) / 2;
            long sq = (long) mid * mid;
            if(sq > x){
                r=mid-1;
            }else if(sq == x){
                return mid;
            }else{
                ans=mid;
                l=mid+1;
            }
        }
        return ans;
    }
}