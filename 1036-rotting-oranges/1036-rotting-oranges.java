class Solution {
    class Node{
        int row;
        int col;
        Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        Queue<Node> q = new LinkedList<>();
        int oneCount = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2) q.offer(new Node(i, j));
                else if(grid[i][j] == 1) oneCount++;
            }
        }
        if (oneCount == 0) return 0;
        int count=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node node = q.poll();
                int row = node.row;
                int col = node.col;
                if(row+1 < m && grid[row+1][col] == 1){
                    q.add(new Node(row+1, col));
                    grid[row+1][col] = 2;
                    oneCount--;
                }
                if(col+1 < n && grid[row][col+1] == 1){
                    q.add(new Node(row, col+1));
                    grid[row][col+1] = 2;
                    oneCount--;
                }
                if(row-1 >= 0 && grid[row-1][col] == 1){
                    q.add(new Node(row-1, col));
                    grid[row-1][col] = 2;
                    oneCount--;
                }
                if(col-1 >= 0 && grid[row][col-1] == 1){
                    q.add(new Node(row, col-1));
                    grid[row][col-1] = 2;
                    oneCount--;
                }
            }
            count++;
        }
        if(oneCount == 0) return count-1;
        return -1;
    }
}