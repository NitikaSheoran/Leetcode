class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int[] res = new int[2];
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int[] last = q.poll();

            int x = last[0];
            int y = last[1];

            char nextM = grid[x][y];
            int newX = -1;
            int newY = -1;
            if(nextM == 'R'){
                newX = x;
                newY = y+1;
            }else if(nextM == 'L'){
                newX = x;
                newY = y-1;
            }else if(nextM == 'U'){
                newX = x-1;
                newY = y;
            }else{
                newX = x+1;
                newY = y;
            }

            // System.out.println("x: "+x+"  y: "+y+"  newX: "+newX+"  newY: "+newY);

            if(newX>=0 && newY>=0 && newX<n && newY<m && !visited[newX][newY]){
                visited[newX][newY] = true;
                q.add(new int[]{newX, newY});
            }else{
                res[0] = x;
                res[1] = y;
                return res;
            }
        }

        return res;
    }
}