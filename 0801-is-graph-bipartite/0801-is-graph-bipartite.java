class Solution {
    public boolean isValid(int node, int color, int[]colors, int[][] graph){
        for(int adj: graph[node]){
            if(colors[adj] == color){
                return false;
            }
        }
        return true;
    }
    public boolean isP(int node, int[][] graph, int[] color, boolean[] visited, int currentColor){
        System.out.println(node + "  " + currentColor);
        if(!isValid(node, currentColor, color, graph)) return false;

        color[node] = currentColor;
        visited[node] = true;

        for(int adj: graph[node]){
            if(!visited[adj]){
                if(!isP(adj, graph, color, visited, 1-currentColor)){
                    return false;
                }
            }else if(color[adj] == currentColor){
                return false;
            }
        }
        // visited[node] = false;

        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i=0; i<n; i++){
            if(!visited[i]){
                if(!isP(i, graph, color, visited, 0)){
                    return false;
                }
            }
        }

        return true;
    }
}