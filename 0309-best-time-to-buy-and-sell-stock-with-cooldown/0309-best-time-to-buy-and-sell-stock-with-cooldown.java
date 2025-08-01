class Solution {
    // recursive

    // public int f(int[] prices, int i, int buy){
    //     if(i >= prices.length) return 0;

    //     if(buy == 1){
    //         return Math.max(-prices[i] + f(prices, i+1, 0), 0 + f(prices, i+1, 1));
    //     }else{
    //         return Math.max(prices[i] + f(prices, i+2, 1), 0 + f(prices, i+1, 0));
    //     }
    // }


    // memo
    public int f(int[] prices, int i, int buy, int[][] dp){
        if(i >= prices.length) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];

        if(buy == 1){
            return dp[i][buy] = Math.max(-prices[i] + f(prices, i+1, 0, dp), 0 + f(prices, i+1, 1, dp));
        }else{
            return dp[i][buy] = Math.max(prices[i] + f(prices, i+2, 1, dp), 0 + f(prices, i+1, 0, dp));
        }
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        for(int i=0; i<=prices.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return f(prices, 0, 1, dp);
        // int n = prices.length;

        // // taulation
        // for(int i=0; i<n; i++){
        //     for(int buy=0; buy<2; buy++){
        //         dp[i][buy][0] = 0;
        //     }
        // }
        // for(int buy=0; buy<2; buy++){
        //     for(int cap=0; cap<3; cap++){
        //         dp[n][buy][cap] = 0;
        //     }
        // }


        // for(int i=n-1; i>=0; i--){
        //     for(int buy=0; buy<2; buy++){
        //         for(int cap=1; cap<=2; cap++){
        //             if(buy == 1){
        //                 dp[i][buy][cap] = Math.max(-prices[i] + dp[i+1][0][cap], 0 + dp[i+1][1][cap]);
        //             }else{
        //                 dp[i][buy][cap] = Math.max(prices[i] + dp[i+1][1][cap-1], 0 + dp[i+1][0][cap]);
        //             }
        //         }
        //     }
        // }

        // return dp[0][1][2];

    }
}