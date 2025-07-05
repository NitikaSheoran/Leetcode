class Solution {
    public void dfs(int node, int[][] adjList, List<Integer> arr, List<List<Integer>> res, int n, boolean[] visited){
        arr.add(node);
        if(node == n-1){
            res.add(new ArrayList<>(arr));
            return;
        }
        visited[node] = true;
        
        for(int adj: adjList[node]){
            if(!visited[adj]){
                dfs(adj, adjList, arr, res, n, visited);
                arr.remove(arr.size()-1);
                visited[adj] = false;
            }
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;

        List<Integer> arr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        
        dfs(0, graph, arr, res, n, visited);

        return res;
    }
}