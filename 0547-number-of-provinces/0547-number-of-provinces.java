class Solution {
    public void dfs(int node, int[][] isConnected, boolean[] visited){
        visited[node] = true;
        for(int i=0; i<isConnected.length; i++){
            if(!visited[i] && isConnected[node][i]==1){
                dfs(i, isConnected, visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }
}