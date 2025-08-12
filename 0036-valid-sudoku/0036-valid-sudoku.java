class Solution {
    public boolean isValid(char[][] board, int r, int c, char ch){
        for(int i=0; i<9; i++){
            if(i!=c && board[r][i] == ch){
                return false;
            }
        }

        for(int i=0; i<9; i++){
            if(i!=r && board[i][c] == ch){
                return false;
            }
        }

        int stRow = (r/3)*3;
        int stCol = (c/3)*3;
        for(int i=stRow; i<stRow+3; i++){
            for(int j=stCol; j<stCol+3; j++){
                if(i!=r && j!=c && board[i][j] == ch) return false;
            }
        }

        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] =='.'){
                    continue;
                }
                if(!isValid(board, i, j, board[i][j])){
                    // System.out.println(i + "  " + j+ "  ");
                    return false;
                }
            }
        }
        return true;
    }
}