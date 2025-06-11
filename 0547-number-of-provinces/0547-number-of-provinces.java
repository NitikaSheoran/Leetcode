class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited){
        visited[node] = true;
        for(int neigh: adjList.get(node)){
            if(!visited[neigh]) dfs(neigh, adjList, visited);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i=0; i<isConnected.length; i++){
            adjList.add(new ArrayList<Integer>());
            visited[i] = false;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j] == 1){
                    adjList.get(i).add(j);
                }
            }
        }
        int count = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, adjList, visited);
                count++;
            }
        }
        return count;
    }
}