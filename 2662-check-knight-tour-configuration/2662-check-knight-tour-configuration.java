class Solution {
    int[][] dir = {{2,1}, {2,-1}, {1,2}, {1,-2}, {-2,1}, {-2,-1}, {-1,2}, {-1,-2}};
    public boolean check(int[][] grid,int n, int row, int col, int count){
        if(count == n*n) return true;
        for(int i=0; i<dir.length; i++){
            if(row+dir[i][0]<n && row+dir[i][0]>=0 && col+dir[i][1]<n && col+dir[i][1]>=0 && grid[row+dir[i][0]][col+dir[i][1]]==count){
                if(check(grid, n, row+dir[i][0], col+dir[i][1], count+1)) return true;
            }
        }
        return false;
    }
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0] !=0)return false;
        return check(grid, grid.length, 0,0,1);
    }
}