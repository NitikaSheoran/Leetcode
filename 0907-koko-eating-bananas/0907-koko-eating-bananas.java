class Solution {
    public int Hours(int rate, int[] piles){
        int hrs = 0;
        for(int i=0; i<piles.length; i++){
            hrs += Math.ceil((double)piles[i]/rate);
        }
        return hrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }
        int r=max;
        while(l<=r){
            int mid = (l+r)/2;
            int hrs = Hours(mid, piles);
            if(hrs > h){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return l;
    }
}