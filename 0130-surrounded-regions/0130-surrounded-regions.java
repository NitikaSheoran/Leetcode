class Solution {
    public void dfs(int i, int j, boolean[][] visited, char[][] board){
        visited[i][j] = true;
        int[][] positions = {{-1,0},{1,0},{0,-1},{0,1}};

        for(int[] pos: positions){
            int newI = i+pos[0];
            int newJ = j+pos[1];

            if(newI>=0 && newJ>=0 && newI<board.length && newJ<board[0].length && board[newI][newJ] == 'O' && !visited[newI][newJ]){
                dfs(newI, newJ, visited, board);
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<n; i++){
            if(!visited[0][i] && board[0][i] == 'O'){
                dfs(0,i,visited,board);
            }
            if(!visited[m-1][i] && board[m-1][i] == 'O'){
                dfs(m-1,i,visited,board);
            }
        }

        for(int i=0; i<m; i++){
            if(!visited[i][0] && board[i][0] == 'O'){
                dfs(i,0,visited,board);
            }
            if(!visited[i][n-1] && board[i][n-1] == 'O'){
                dfs(i,n-1,visited,board);
            }
        }


        for(int i=0; i<m; i++){
            for(int j =0; j<n; j++){
                if(!visited[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}