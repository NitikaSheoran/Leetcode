class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<int[]>());
        }

        for(int i=0; i<redEdges.length; i++){
            int[] edge = redEdges[i];
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(new int[]{v, 1});
        }
        for(int i=0; i<blueEdges.length; i++){
            int[] edge = blueEdges[i];
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(new int[]{v, 0});
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, -1});
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        int dis = 0;
        boolean[][] visited = new boolean[n][2];
        visited[0][0] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] top = q.poll();
                int u = top[0];
                int color = top[1];
                if(dis < res[u]) res[u] = dis;
                for(int[] adj: adjList.get(u)){
                    int v = adj[0];
                    int vColor = adj[1];
                    if(!visited[v][vColor] && vColor != color){
                        visited[v][vColor] = true;
                        q.add(new int[]{v, vColor});
                    }
                }
            }
            dis++;
        }
        for(int i=1; i<n; i++){
            if(res[i] == Integer.MAX_VALUE){
                res[i] = -1;
            }
        }
        return res;
    }
}