class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        for(int i=0; i<matrix.length; i++){
            pq.add(new int[]{matrix[i][0], i, 0});
        }
        for(int i=0; i<k-1; i++){
            int[] min = pq.poll();
            int row = min[1];
            int col = min[2];
            if(col+1<matrix[0].length){
                pq.add(new int[]{matrix[row][col+1], row, col+1});
            }
        }
        return pq.poll()[0];
    }
}