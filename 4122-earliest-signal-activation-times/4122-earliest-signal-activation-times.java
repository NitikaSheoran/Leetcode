class Solution {
    class Node{
        int v;
        long delay;
        Node(int v, long delay){
            this.v = v;
            this.delay = delay;
        }
    }
    public long[] earliestActivationTimes(int n, int[][] edges, int[] requiredSignals) {
        List<List<Node>> adjL = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjL.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int delay = edge[2];
            adjL.get(u).add(new Node(v, delay));
        }

        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->Long.compare(a.delay, b.delay));
        // q.add(new Node(0,0));
        
        long[] dist = new long[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;

        for(Node node: adjL.get(0)){
            q.add(new Node(node.v, node.delay));
        }

        while(!q.isEmpty()){
            Node top = q.poll();
            int u = top.v;
            long t = top.delay;
            if(dist[u] >= 0) continue;

            requiredSignals[u]--;
            if(requiredSignals[u]==0){
                dist[u] = t;
                for(Node adj: adjL.get(u)){
                    if(dist[adj.v]<0){
                        q.add(new Node(adj.v, t+adj.delay));
                    }
                }
            }
            
        }
        return dist;
    }
}