class Solution {
    public void dfs(int node, boolean[] visited, List<List<Integer>> adjList){
        visited[node] = true;
        for(int adj: adjList.get(node)){
            if(!visited[adj]){
                dfs(adj, visited, adjList);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, visited, rooms);
                count++;
                if(count>1){
                    return false;
                }
            }
        }
        return true;
        
    }
}