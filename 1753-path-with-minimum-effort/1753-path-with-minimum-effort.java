class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        pq.add(new int[]{0, 0, 0});
        int maxEffort = 0;
        int m = heights.length;
        int n = heights[0].length;

        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;


        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int effort = top[0];
            int row = top[1];
            int col = top[2];

            if(row == m-1 && col == n-1) return effort;

            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for(int[] direction: directions){
                int r = row + direction[0];
                int c = col + direction[1];
                if(r >= 0 && r<m && c>=0 && c<n){
                    int currEffort = Math.max(effort, Math.abs(heights[r][c] - heights[row][col]));
                    if (currEffort < dist[r][c]) {
                        dist[r][c] = currEffort;
                        pq.offer(new int[]{currEffort, r, c});
                    }
                }
            }
        }
        return 0;
    }
}