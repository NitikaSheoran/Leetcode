class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // boolean[][] visited = new boolean[m][n];
        int[] row = new int[m];
        int[] col = new int[n];
        int res = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    row[i]++;
                    col[j]++;
                }
            }
        }
        

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    if(row[i]>1 || col[j]>1){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}