class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            if (x[0] != y[0]) return x[0] - y[0];
            return x[1] - y[1]; 
        });

        int n = costs.length;
        int left = 0, right = n - 1;
        for (int i = 0; i < candidates && left <= right; i++) {
            pq.add(new int[]{costs[left], left++});
        }
        for (int i = 0; i < candidates && left <= right; i++) {
            pq.add(new int[]{costs[right], right--});
        }

        long total = 0;

        for (int i = 0; i < k; i++) {
            int[] curr = pq.poll();
            total += curr[0];
            if (left <= right) {
                if (curr[1] < left) {
                    pq.add(new int[]{costs[left], left++});
                } else {
                    pq.add(new int[]{costs[right], right--});
                }
            }
        }

        return total;
    }
}
