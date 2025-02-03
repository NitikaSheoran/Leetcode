class Solution {
    public int days(int[] weight, int cap){
        int load = 0;
        int days = 1;
        int n = weight.length;
        for(int i=0; i<n; i++){
            if(load + weight[i] > cap){
                days += 1;
                load = weight[i];
            }else{
                load += weight[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int maxW = Integer.MIN_VALUE;
        int max = 0;
        for(int i=0; i<n; i++){
            maxW =  Math.max(maxW, weights[i]);
            max += weights[i];
        }
        int l = maxW;
        int r = max;
        while(l<=r){
            int mid = (l+r)/2;
            int d = days(weights,mid);
            if(d <= days){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}