class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public void checkDirections(int[][] grid, int i, int j, Queue<Pair> q, boolean[][] visited){
        int n = grid.length;
        if(i-1 >= 0 && j<n && grid[i-1][j] == 0 && !visited[i-1][j]) {
            visited[i-1][j] = true;
            q.add(new Pair(i-1,j));
        } 
        if(j-1 >= 0 && i<n && grid[i][j-1] == 0 && !visited[i][j-1]) {
            visited[i][j-1] = true;
            q.add(new Pair(i,j-1));
        }
        if(i+1 < n && j<n && grid[i+1][j] == 0 && !visited[i+1][j]) {
            visited[i+1][j] = true;
            q.add(new Pair(i+1,j));
        }
        if(j+1 < n && i<n && grid[i][j+1] == 0 && !visited[i][j+1]) {
            visited[i][j+1] = true;
            q.add(new Pair(i,j+1));
        }
        if(i+1 < n && j+1<n && grid[i+1][j+1] == 0 && !visited[i+1][j+1]) {
            visited[i+1][j+1] = true;
            q.add(new Pair(i+1,j+1));
        } 
        if(i+1 < n && j-1>=0 && grid[i+1][j-1] == 0 && !visited[i+1][j-1]) {
            visited[i+1][j-1] = true;
            q.add(new Pair(i+1,j-1));
        } 
        if(i-1 >= 0 && j+1<n && grid[i-1][j+1] == 0 && !visited[i-1][j+1]) {
            visited[i-1][j+1] = true;
            q.add(new Pair(i-1,j+1));
        }
        if(i-1 >= 0 && j-1>=0 && grid[i-1][j-1] == 0 && !visited[i-1][j-1]){
            visited[i-1][j-1] = true;
            q.add(new Pair(i-1,j-1));
        }  
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0) return -1;
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        int n = grid.length;

        // apply dfs (short path for directed graph with unit edge weight)
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        int dis = 0;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Pair top = q.poll();
                int row = top.row;
                int col = top.col;
                if(col == n-1 && row == n-1){
                    return dis+1;
                }
                checkDirections(grid, row, col, q, visited);
            }
            dis++;
        }
        return -1;
    }
}