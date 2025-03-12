class Solution {
   public boolean isSafe(int row, int col, char[][] board) {
    // Check the same row
    for (int i = 0; i < board.length; i++) {
        if (board[row][i] == 'Q') {
            return false;
        }
    }
       
    // Check the same column
    for (int i = 0; i < board[0].length; i++) {
        if (board[i][col] == 'Q') {
            return false;
        }
    }

    // Check the upper left diagonal
    int r = row;
    int c = col;
    while (r >= 0 && c >= 0) {
        if (board[r][c] == 'Q') {
            return false;
        }
        r--;
        c--;
    }

   
    // Check the lower left diagonal
    r = row;
    c = col;
    while (r < board.length && c >= 0) {
        if (board[r][c] == 'Q') {
            return false;
        }
        r++;
        c--;
    }

   

    return true;
}
    public void result(char[][] board,List<List<String>> allBoards){
        List<String> newBoard = new ArrayList<String>();
        for(int i = 0;i<board.length;i++){
            String row = "";
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == 'Q'){
                    row+='Q';
                }else{
                    row+='.';
                }
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }
    public void position(char[][] board,List<List<String>> allBoards,int col){
        if(col == board.length){
            result(board,allBoards);
            return;
        }
        for(int i = 0;i<board.length;i++){
            if(isSafe(i,col,board)){
                board[i][col] = 'Q';
                position(board,allBoards,col+1);
                board[i][col] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        position(board, allBoards, 0);
        return allBoards;
    }
}