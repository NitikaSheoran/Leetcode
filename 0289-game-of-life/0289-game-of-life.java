class Solution {
    public void gameOfLife(int[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        int m = board.length;
        int n = board[0].length;

        boolean[][] changed = new boolean[m][n];
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] top = queue.poll();
            int i = top[0];
            int j = top[1];

            int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}, {-1, -1}, {-1, 1}, {1,-1}, {1,1}};
            int one=0;
            int zero=0;
            for(int[] dir: dirs){
                int r = dir[0]+i;
                int c = dir[1]+j;
                if(r>=0 && c>=0 && r<board.length && c<board[0].length){
                    if(!changed[r][c]){
                        if(board[r][c] == 0){
                            zero++;
                        }else{
                            one++;
                        }
                    }else{
                        if(board[r][c] == 0){
                            one++;
                        }else{
                            zero++;
                        }
                    }
                    if(!visited[r][c]){
                        visited[r][c] = true;
                        queue.add(new int[]{r,c});
                    }
                }
            }
            if(board[i][j] == 1){
                if(one<2){
                    board[i][j] = 0;
                    changed[i][j] = true;
                }
                if(one>3){
                    board[i][j]=0;
                    changed[i][j] = true;
                }
            }else{
                if(one==3){
                    board[i][j] = 1;
                    changed[i][j] = true;
                }
            }
        }
    }
}