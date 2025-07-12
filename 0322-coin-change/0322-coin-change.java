class Solution {
    public int f(int idx, int target, int[] arr, int[][] dp){
        if(idx == 0){
            if(target%arr[idx] == 0){
                return target/arr[idx];
            }else {
                return (int)1e9;
            }
        }

        if(dp[idx][target] != -1) return dp[idx][target];

        int nottake = f(idx-1, target, arr, dp);
        int take = (int)1e9;
        if(target >= arr[idx]){
            take = 1+ f(idx, target-arr[idx], arr, dp);
        }

        return dp[idx][target] = Math.min(take, nottake);
    }
    public int coinChange(int[] coins, int amount) {
        // cant use greedy -> wrong ans to many test cases
        // Arrays.sort(coins);
        // if(amount == 0) return 0;
        // int r = coins.length-1;
        // int count=0;
        // while(r>=0){
        //     while(amount >= coins[r]){
        //         count++;
        //         amount -= coins[r];
        //     }
        //     r--;
        // }
        // return amount <= 0? count: -1;

        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        
        int res = f(n-1, amount, coins, dp);
        return  res == (int)1e9 ? -1: res;
    }
}