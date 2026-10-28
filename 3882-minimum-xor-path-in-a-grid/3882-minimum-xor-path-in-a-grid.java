// class Solution {

//     public int f(int i, int j, int[][] grid, int xor){
//         xor = xor^grid[i][j];
//         if(i == grid.length-1 && j == grid[0].length-1){
//             return xor;
//         }
//         int down = Integer.MAX_VALUE;
//         int right = Integer.MAX_VALUE;
//         if(i<grid.length-1){
//             down = f(i+1, j, grid, xor);
//         }
//         if(j<grid[0].length-1){
//             right = f(i, j+1, grid, xor);
//         }

//         return Math.min(right, down);

//     }
//     public int minCost(int[][] grid) {
        
//         return f(0, 0, grid, 0);
        
//     }
// }
public class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] dp = new boolean[n][1024];
        
        dp[0][grid[0][0]] = true;
        
        for (int j = 1; j < n; j++) {
            int val = grid[0][j];
            for (int k = 0; k < 1024; k++) {
                if (dp[j - 1][k]) {
                    dp[j][k ^ val] = true;
                }
            }
        }
        
        for (int i = 1; i < m; i++) {
            boolean[][] nextDp = new boolean[n][1024];
            
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                
                for (int k = 0; k < 1024; k++) {
                    if (dp[j][k]) {
                        nextDp[j][k ^ val] = true;
                    }
                }
                
                if (j > 0) {
                    for (int k = 0; k < 1024; k++) {
                        if (nextDp[j - 1][k]) {
                            nextDp[j][k ^ val] = true;
                        }
                    }
                }
            }
            dp = nextDp; 
        }
        
        for (int k = 0; k < 1024; k++) {
            if (dp[n - 1][k]) {
                return k;
            }
        }
        
        return 0;
    }
}