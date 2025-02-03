class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0;
        int r = arr.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            int missing = arr[mid] - mid -1;
            if(missing >= k){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        int x;
        int m;
        if(r < 0){
            x = 1;
            m = k-1;
        }else{
            x = arr[r];
            m = k - (arr[r] - r -1);
        }
        return x+m;
    }
}