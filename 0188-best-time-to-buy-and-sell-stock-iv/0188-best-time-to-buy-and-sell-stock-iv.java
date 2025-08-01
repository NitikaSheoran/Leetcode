class Solution {
    // recursive

    // public int f(int[] prices, int i, int buy, int cap){
    //     if(cap == 0) return 0;
    //     if(i == prices.length) return 0;

    //     if(buy == 1){
    //         return Math.max(-prices[i] + f(prices, i+1, 0, cap), 0 + f(prices, i+1, 1, cap));
    //     }else{
    //         return Math.max(prices[i] + f(prices, i+1, 1, cap-1), 0 + f(prices, i+1, 0, cap));
    //     }
    // }


    // memo
    // public int f(int[] prices, int i, int buy, int cap, int[][][] dp){
    //     if(cap == 0) return 0;
    //     if(i == prices.length) return 0;
    //     if(dp[i][buy][cap] != -1) return dp[i][buy][cap];

    //     if(buy == 1){
    //         return dp[i][buy][cap] = Math.max(-prices[i] + f(prices, i+1, 0, cap, dp), 0 + f(prices, i+1, 1, cap, dp));
    //     }else{
    //         return dp[i][buy][cap] = Math.max(prices[i] + f(prices, i+1, 1, cap-1, dp), 0 + f(prices, i+1, 0, cap, dp));
    //     }
    // }
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length+1][2][k+1];
        for(int i=0; i<=prices.length; i++){
            for(int j=0; j<2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        // return f(prices, 0, 1, k, dp);
        int n = prices.length;

        // taulation
        for(int i=0; i<n; i++){
            for(int buy=0; buy<2; buy++){
                dp[i][buy][0] = 0;
            }
        }
        for(int buy=0; buy<2; buy++){
            for(int cap=0; cap<=k; cap++){
                dp[n][buy][cap] = 0;
            }
        }


        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<2; buy++){
                for(int cap=1; cap<=k; cap++){
                    if(buy == 1){
                        dp[i][buy][cap] = Math.max(-prices[i] + dp[i+1][0][cap], 0 + dp[i+1][1][cap]);
                    }else{
                        dp[i][buy][cap] = Math.max(prices[i] + dp[i+1][1][cap-1], 0 + dp[i+1][0][cap]);
                    }
                }
            }
        }

        return dp[0][1][k];

    }
}