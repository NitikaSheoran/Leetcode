class Solution {
    public boolean cit(int[] citations, int mid){
        int count=0;
        for(int i=citations.length-1; i>=0; i--){
            if(citations[i] >= mid) count++;
            if(count>=mid) return true;
        }
        return false;
    }
    public int hIndex(int[] citations) {
        int l=0;
        int r=citations.length;
        int ans=0;
        while(l<=r){
            int mid = (l+r)/2;
            if(cit(citations, mid)){
                ans=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }
}