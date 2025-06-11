class Solution {
    class Node{
        int row;
        int col;
        Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        if(image[sr][sc] == color) return image;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sr, sc));
        int initialColor = image[sr][sc];
        image[sr][sc] = color;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node node = q.poll();
                int row = node.row;
                int col = node.col;
                if(row+1 < m && image[row+1][col] == initialColor){
                    image[row+1][col] = color;
                    q.add(new Node(row+1, col));
                }
                if(col+1 < n && image[row][col+1] == initialColor){
                    image[row][col+1] = color;
                    q.add(new Node(row, col+1));
                }
                if(row-1 >= 0 && image[row-1][col] == initialColor){
                    image[row-1][col] = color;
                    q.add(new Node(row-1, col));
                }
                if(col-1 >= 0 && image[row][col-1] == initialColor){
                    image[row][col-1] = color;
                    q.add(new Node(row, col-1));
                }
            }
        }
        return image;
    }
}