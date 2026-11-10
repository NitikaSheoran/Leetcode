class Solution {
    public void dfs(int i, int j, boolean[][] visited, char[][] board, int m, int n){
        visited[i][j] = true;

        int[][] adjL = {{0,1},{0,-1},{-1,0},{1,0}};

        for(int[] adj: adjL){
            int newI = i+adj[0];
            int newJ = j+adj[1];
            if(newI>=0 && newJ>=0 && newI<m && newJ<n && !visited[newI][newJ] && board[newI][newJ] == 'O'){
                dfs(newI, newJ, visited, board, m, n);
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            if(!visited[i][0] && board[i][0] == 'O'){
                dfs(i, 0, visited, board, m, n);
            }
            if(!visited[i][n-1] && board[i][n-1] == 'O'){
                dfs(i, n-1, visited, board, m, n);
            }
        }

        for(int i=0; i<n; i++){
            if(!visited[0][i] && board[0][i] == 'O'){
                dfs(0, i, visited, board, m, n);
            }
            if(!visited[m-1][i] && board[m-1][i] == 'O'){
                dfs(m-1, i, visited, board, m, n);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
}