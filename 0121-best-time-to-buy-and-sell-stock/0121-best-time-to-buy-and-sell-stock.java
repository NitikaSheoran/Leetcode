class Solution {
    public int maxProfit(int[] prices) {
        
        int n=prices.length;
        int maxDiff = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0;i<n; i++){
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }
            maxDiff = Math.max(maxDiff, prices[i]-minPrice);
        }
        return maxDiff;
    }
}