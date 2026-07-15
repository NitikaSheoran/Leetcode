class Solution {
    class Node{
        int row;
        int col;
        public Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int oneC = 0;
        Queue<Node> queue = new LinkedList<>();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 2){
                    queue.add(new Node(i, j));
                }
                if(grid[i][j] == 1){
                    oneC++;
                }
            }
        }
        if(oneC == 0) return 0;
        int count = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node top = queue.poll();
                int r = top.row;
                int c = top.col;
                if(r-1 >=0 && grid[r-1][c]==1){
                    queue.add(new Node(r-1, c));
                    grid[r-1][c] = 2;
                    oneC--;
                }
                if(r+1 < row && grid[r+1][c] == 1){
                    queue.add(new Node(r+1, c));
                    grid[r+1][c] = 2;
                    oneC--;
                }
                if(c-1>=0 && grid[r][c-1] == 1){
                    queue.add(new Node(r, c-1));
                    grid[r][c-1]=2;
                    oneC--;
                }
                if(c+1<col && grid[r][c+1]==1){
                    queue.add(new Node(r,c+1));
                    grid[r][c+1]=2;
                    oneC--;
                }
            }
            count++;
        }
        if(oneC == 0) return count-1;
        return -1;
    }
}