class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public boolean isDest(Pair p, int m, int n){
        int r = p.r;
        int c = p.c;
        if(r == 0 || r==m-1 || c==0 || c==n-1){
            return true;
        }
        return false;
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int row = entrance[0];
        int col = entrance[1];
        if(maze[row][col]=='+') return -1;
        

        int m = maze.length;
        int n = maze[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        boolean[][] visited = new boolean[m][n];
        visited[row][col] = true;

        int count=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Pair p = q.poll();
                int cr = p.r;
                int cc = p.c;
                if(isDest(p, m, n) && !(cr == row && cc == col)){
                    return count;
                }
                int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
                for(int[] d: dir){
                    int r = d[0];
                    int c = d[1];
                    if(cr+r<m && cr+r>=0 && cc+c<n && cc+c>=0 && !visited[cr+r][cc+c] && maze[cr+r][cc+c]=='.'){
                        visited[cr+r][cc+c] = true;
                        q.add(new Pair(cr+r, cc+c));
                    }
                }
            }
            count++;
        }

        return -1;
    }
}