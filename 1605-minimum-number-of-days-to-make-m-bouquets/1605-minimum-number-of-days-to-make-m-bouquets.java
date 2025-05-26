class Solution {
    public int noOfBouq(int days, int[] bloomDay, int k){
        int ans=0;
        int count=0;
        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i] <= days){
                count++;
            }else{
                count=0;
            }
            if(count == k){
                ans++;
                count=0;
            }
        }
        return ans;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int l = 0;
        int r = 0;
        int ans = -1;
        for(int i=0; i<bloomDay.length; i++){
            r = Math.max(bloomDay[i], r);
        }
        while(l<=r){
            int mid = (l+r)/2;
            int bouq = noOfBouq(mid, bloomDay, k);
            if(bouq >= m){
                ans = mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}