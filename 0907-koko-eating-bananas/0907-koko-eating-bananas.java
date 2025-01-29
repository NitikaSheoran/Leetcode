class Solution {
    public int hours(int[] piles, int hourly){
        int hrs=0;
        for(int i=0; i<piles.length; i++){
            hrs += (int)Math.ceil((double)piles[i] / hourly);
        }
        return hrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int n=piles.length;
        int max = 0;
        for(int i=0; i<n; i++){
            if(piles[i]>max){
                max = piles[i];
            }
        }
        int r=max;
        int ans=0;
        while(l<r){
            int mid = (l+r)/2;
            int hrs = hours(piles,mid);
            if(hrs<=h){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}