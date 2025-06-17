class Solution {
    int timer = 0;
    public void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int[] tin, int[] low, List<List<Integer>> res){
        visited[node] = true;
        tin[node] = low[node] = timer;
        timer++;

        for(int adj: adjList.get(node)){
            if(adj == parent) continue;

            if(!visited[adj]){
                dfs(adj, node, adjList, visited, tin, low, res);
                low[node] = Math.min(low[node], low[adj]);
                if(low[adj] > tin[node]){
                    List<Integer> arr = new ArrayList<>();
                    arr.add(adj);
                    arr.add(node);
                    res.add(arr);
                }
            }else{
                low[node] = Math.min(low[node], tin[adj]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] tin = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(low, 0);
        Arrays.fill(low, 0);
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(List<Integer> edge: connections){
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, i, adjList, visited, tin, low, res);
            }
        }
        return res;
    }
}