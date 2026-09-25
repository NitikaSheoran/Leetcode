class Solution {
    public boolean isValid(int row, int col, char[][] board){
        // check row
        for(int i=0; i<board.length; i++){
            if(i!=col && board[row][i] == 'Q'){
                return false;
            }
        }

        // check col
        for(int i=0; i<board.length; i++){
            if(i!=row && board[i][col]=='Q'){
                return false;
            }
        }

        // upper left diag
        int i = row-1;
        int j = col-1;
        while(i>=0 && j>=0){
            if(board[i][j] == 'Q') return false;
            i = i-1;
            j = j-1;
        }

        i = row+1;
        j = col+1;
        while(i<board.length && j<board.length){
            if(board[i][j] == 'Q') return false;
            i++;
            j++;
        }

        i=row+1;
        j=col-1;
        while(i<board.length && j>=0){
            if(board[i][j] == 'Q') return false;
            i++;
            j--;
        }

        i=row-1;
        j=col+1;
        while(i>=0 && j<board.length){
            if(board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        return true;
    }
    public void addBoard(List<List<String>> boards, char[][] board){
        ArrayList<String> arr = new ArrayList<>();

        for(int i=0; i<board.length; i++){
            String str = "";
            for(int j=0; j<board.length; j++){
                str+=board[i][j];
            }
            arr.add(str);
        }
        boards.add(arr);
    }
    public void f(char[][] board, List<List<String>> boards, int col, int n){
        if(col == n){
            addBoard(boards, board);
            return;
        }

        for(int i=0; i<n; i++){
            if(isValid(i, col, board)){
                board[i][col] = 'Q';
                f(board, boards, col+1, n);
                board[i][col] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        f(board, res, 0, n);
        return res;
    }
}