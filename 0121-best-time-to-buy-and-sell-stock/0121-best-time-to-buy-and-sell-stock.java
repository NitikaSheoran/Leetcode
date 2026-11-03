class Solution {
    public int maxProfit(int[] prices) {
        int maxP = Integer.MIN_VALUE;
        int minP = prices[0];
        for(int i=0; i<prices.length; i++){
            maxP = Math.max(maxP, prices[i]-minP);
            minP = Math.min(minP, prices[i]);
        }
        return maxP;
    }
}