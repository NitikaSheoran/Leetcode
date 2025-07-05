class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                adj.get(manager[i]).add(i);
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{headID, 0});  

        int maxTime = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int emp = curr[0];
            int timeSoFar = curr[1];
            maxTime = Math.max(maxTime, timeSoFar);
            for (int sub : adj.get(emp)) {
                q.add(new int[]{sub, timeSoFar + informTime[emp]});
            }
        }

        return maxTime;
    }
}
