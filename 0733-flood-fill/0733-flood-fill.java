class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue = new LinkedList<>();
        int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        queue.add(new int[]{sr,sc,image[sr][sc]});
        image[sr][sc] = color;
        visited[sr][sc] = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] top = queue.poll();
                int c = top[2];
                int[][] positions = {{-1,0},{1,0},{0,1},{0,-1}};
                for(int[] pos: positions){
                    int newI = top[0]+pos[0];
                    int newJ = top[1] + pos[1];

                    if(newI>=0 && newJ>=0 && newI<m && newJ<n && !visited[newI][newJ] && image[newI][newJ] == c){
                        queue.add(new int[]{newI,newJ,image[newI][newJ]});
                        image[newI][newJ] = color;
                        visited[newI][newJ] = true;
                        
                    }
                }
            }
        }
        return image;
    }
}