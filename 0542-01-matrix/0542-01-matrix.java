class Solution {
    public class Node{
        int i;
        int j;
        int dis;
        Node(int i, int j, int dis){
            this.i = i;
            this.j = j;
            this.dis = dis;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];

        boolean[][] visited = new boolean[m][n];

        Queue<Node> queue = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    queue.add(new Node(i,j,0));
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            Node top = queue.poll();
            int i = top.i;
            int j = top.j;
            res[i][j] = top.dis;

            int[][] position = {{-1,0},{1,0},{0,1},{0,-1}};
            for(int[] pos: position){
                int newI = pos[0] + i;
                int newJ = pos[1] + j;
                if(newI >= 0 && newJ >=0 && newI<m && newJ<n && !visited[newI][newJ] && mat[newI][newJ] == 1){
                    queue.add(new Node(newI,newJ,top.dis+1));
                    visited[newI][newJ] = true;
                }
            }
        }
        return res;
    }
}