class Solution {
    public boolean dfs(int i, int j, char[][] board, String str, String word, int idx, boolean[][] visited){
        str = str+board[i][j];
        
        if(str.charAt(idx) != word.charAt(idx)) return false;
        if(idx == word.length()-1) return true;

        visited[i][j] = true;
        
        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        for(int[] dir: dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            if(r>=0 && c>=0 && r<board.length && c<board[0].length && !visited[r][c]){
                if(dfs(r, c, board, str, word, idx+1, visited)) return true;
            }
        }

        visited[i][j] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[m][n];
                    if(dfs(i, j, board, "", word, 0, visited)){
                        return true;
                    } 
                }              
            }
        }

        return false;
    }
}
