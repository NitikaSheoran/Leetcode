class Solution {
    // recursive

    // public int f(int[] prices, int i, int buy, int fee){
    //     if(i >= prices.length) return 0;

    //     if(buy == 1){
    //         return Math.max(-prices[i] + f(prices, i+1, 0, fee), 0 + f(prices, i+1, 1, fee));
    //     }else{
    //         return Math.max(prices[i]-fee + f(prices, i+2, 1, fee), 0 + f(prices, i+1, 0, fee));
    //     }
    // }


    // memo
    // public int f(int[] prices, int i, int buy, int[][] dp, int fee){
    //     if(i >= prices.length) return 0;
    //     if(dp[i][buy] != -1) return dp[i][buy];

    //     if(buy == 1){
    //         return dp[i][buy] = Math.max(-prices[i] + f(prices, i+1, 0, dp, fee), 0 + f(prices, i+1, 1, dp, fee));
    //     }else{
    //         return dp[i][buy] = Math.max(prices[i]-fee + f(prices, i+2, 1, dp, fee), 0 + f(prices, i+1, 0, dp, fee));
    //     }
    // }
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length+1][2]; 
        for(int i=0; i<=prices.length; i++){
            Arrays.fill(dp[i], -1);
        }

        // return f(prices, 0, 1, dp, fee);
        int n = prices.length;

        // taulation
        for(int buy=0; buy<2; buy++){
                dp[n][buy] = 0;
        }


        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<2; buy++){
                
                if(buy == 1){
                    dp[i][buy] = Math.max(-prices[i] + dp[i+1][0], 0 + dp[i+1][1]);
                }else{
                    dp[i][buy] = Math.max(prices[i]-fee + dp[i+1][1], 0 + dp[i+1][0]);
                }
                
            }
        }

        return dp[0][1];

    }
}