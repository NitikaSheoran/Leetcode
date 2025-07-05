class Solution {
    List<int[]> bfsQueue;
    public void dfs(int[][] grid, int x, int y, int n){
        grid[x][y] = 2;
        bfsQueue.add(new int[]{x, y});
        for(int[] adj: new int[][]{
            {x+1, y},
            {x, y+1},
            {x-1, y},
            {x, y-1}
        }){
            int cX = adj[0];
            int cY = adj[1];
            if(cX >= 0 && cX < n && cY >= 0 && cY < n && grid[cX][cY] == 1){
                dfs(grid, cX, cY, n);
            }
        }
    }
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int fX = -1;
        int fY = -1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    fX = i;
                    fY = j;
                    break;
                }
            }
        }

        bfsQueue = new ArrayList<>();
        dfs(grid, fX, fY, n);

        int dis = 0;

        while(!bfsQueue.isEmpty()){
            List<int[]> newBfs = new ArrayList<>();
            for(int[] pair: bfsQueue){
                int x = pair[0];
                int y = pair[1];
                for(int[] nextPair: new int[][]{
                    {x+1, y},
                    {x, y+1},
                    {x-1, y},
                    {x, y-1}
                }){
                    int newX = nextPair[0];
                    int newY = nextPair[1];
                    if(newX >= 0 && newX < n && newY >= 0 && newY < n){
                        if(grid[newX][newY] == 1){
                            return dis;
                        }else if(grid[newX][newY] == 0){
                            newBfs.add(new int[] {newX, newY});
                            grid[newX][newY] = -1;
                        }
                    }
                }
            }

            dis++;
            bfsQueue = newBfs;
        }
        return dis;

    }
}