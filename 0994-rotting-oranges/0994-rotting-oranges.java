class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        int fresh = 0;

        for(int i=0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                }
                if(grid[i][j] == 1) fresh++;
            }
        }
        if(fresh == 0) return 0;
        if(queue.size() == 0) return -1;
        

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] top = queue.poll();
                int[][] positions = {{0,-1},{0,1},{-1,0},{1,0}};
                for(int[] pos: positions){
                    int newI = top[0]+pos[0];
                    int newJ = top[1] + pos[1];
                    if(newI >=0 && newJ>=0 && newI<m && newJ<n && !visited[newI][newJ] && grid[newI][newJ] == 1){
                        visited[newI][newJ] = true;
                        queue.add(new int[]{newI, newJ});
                        fresh--;
                    }
                }
            }
            count++;
            if(fresh == 0) return count;
        }
        for(int i=0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return count;
    }
}