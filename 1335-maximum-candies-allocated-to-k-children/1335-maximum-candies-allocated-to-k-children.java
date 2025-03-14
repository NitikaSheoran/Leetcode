class Solution {
    public boolean Maxcandies(int[] candies, int x, long k){
        long count=0;
        for(int i=0; i<candies.length; i++){
            count += candies[i]/x;
        }
        if(count >= k) return true;
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        int min = 0;
        int max = candies[candies.length-1];
        while(min < max){
            int mid = (min + max+1)/2;
            boolean k2 = Maxcandies(candies, mid, k);
            if(k2){
                min = mid;
            }else{
                max=mid-1;
            }
        }
        return min;
    }
}