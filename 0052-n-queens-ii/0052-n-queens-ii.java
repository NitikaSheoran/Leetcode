class Solution {
    public boolean isValid(char[][] board, int r, int c){
        for(int i=0; i<board.length; i++){
            if(board[i][c] == 'Q') return false;
        }
        for(int i=0; i<board.length; i++){
            if(board[r][i] == 'Q') return false;
        }
        int row = r;
        int col = c;
        while(row>=0 && col>=0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row=r;
        col=c;
        while(col>=0 && row<board.length){
            if(board[row][col] == 'Q') return false;
            col--;
            row++;
        }

        return true;
    }
    public void f(int n, char[][] board, int col, List<Integer> res){
        if(col == n){
            res.add(0, res.get(0)+1);
            return;
        }

        for(int i=0; i<n; i++){
            if(isValid(board, i, col)){
                board[i][col] = 'Q';
                f(n, board, col+1, res);
                board[i][col] = '.';
            }
        }
    }
    public int totalNQueens(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        f(n, board, 0, res);
        return res.get(0);
    }
}