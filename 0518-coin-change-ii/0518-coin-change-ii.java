class Solution {
    public int find(int i, int target, int[] arr, int[][] dp){
        if(i<0){
            return 0;
        }

        if(target == 0) return 1;

        if(dp[i][target] != -1) return dp[i][target];

        int nottake = find(i-1, target, arr, dp);
        int take = 0;
        if(target >= arr[i]){
            take = find(i, target-arr[i], arr, dp);
        }

        return dp[i][target] = take + nottake;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return find(n-1, amount, coins, dp);
    }
}