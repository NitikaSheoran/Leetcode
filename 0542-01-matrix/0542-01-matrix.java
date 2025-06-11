// class Solution {
//     class Node{
//         int row;
//         int col;
//         Node(int row, int col){
//             this.row = row;
//             this.col = col;
//         }
//     }
//     public int bfs(int[][] mat, int row, int col){
//         int m = mat.length;
//         int n = mat[0].length;
//         boolean[][] visited = new boolean[m][n];
//         visited[row][col] = true;
//         Queue<Node> q = new LinkedList<>();
//         q.add(new Node(row, col));
//         int dis = 0;
//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i=0; i<size; i++){
//                 Node node = q.poll();
//                 int r = node.row;
//                 int c = node.col;
//                 if(mat[node.row][node.col] == 0){
//                     return dis;
//                 }else{
//                     if(r+1 < m && !visited[r+1][c]) {
//                         q.add(new Node(r+1, c));
//                         visited[r+1][c] = true;
//                     }
//                     if(c+1 < n && !visited[r][c+1]) {
//                         q.add(new Node(r, c+1));
//                         visited[r][c+1] = true;
//                     }
//                     if(r-1 >= 0 && !visited[r-1][c]) {
//                         q.add(new Node(r-1, c));
//                         visited[r-1][c] = true;
//                     }
//                     if(c-1 >= 0 && !visited[r][c-1]) {
//                         q.add(new Node(r, c-1));
//                         visited[r][c-1] = true;
//                     }
//                 }
//             }
//             dis++;
//         }
//         return -1;
//     }
//     public int[][] updateMatrix(int[][] mat) {
//         int m = mat.length;
//         int n = mat[0].length;
        
//         int[][] res = new int[m][n];
        
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 if(mat[i][j] == 0){
//                     res[i][j] = 0;
//                 }else{
//                     res[i][j] = bfs(mat, i, j);
//                 }
//             }
//         }
//         return res;
//     }
// }

class Solution {
    class Node {
        int row, col, dist;
        Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<Node> q = new LinkedList<>();

        // 1. Push all 0s into the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        // 2. Directions: up, down, left, right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 3. BFS
        while (!q.isEmpty()) {
            Node node = q.poll();
            res[node.row][node.col] = node.dist;

            for (int d = 0; d < 4; d++) {
                int newRow = node.row + dx[d];
                int newCol = node.col + dy[d];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                    !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    q.add(new Node(newRow, newCol, node.dist + 1));
                }
            }
        }

        return res;
    }
}
