class Solution {
    class Pair{
        int node;
        int stops;
        int cost;
        Pair(int node, int stops, int cost){
            this.node = node;
            this.stops = stops;
            this.cost = cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<flights.length; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];
            adjList.get(u).add(new int[]{v, wt});
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0, 0));

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while(!q.isEmpty()){
            Pair top = q.poll();
            int node = top.node;
            int stops = top.stops;
            int cost = top.cost;

            if(stops > k) continue;

            for(int[] adj: adjList.get(node)){
                int v = adj[0];
                int wt = adj[1];
                if(cost + wt < dist[v]){
                    dist[v] = cost + wt;
                    q.add(new Pair(v, stops+1, dist[v]));
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }
}