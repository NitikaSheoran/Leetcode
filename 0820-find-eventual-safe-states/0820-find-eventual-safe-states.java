class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] inDegree = new int[graph.length];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<graph.length; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<graph.length; i++){
            for(int adj: graph[i]){
                adjList.get(adj).add(i);
            }
        }
        for(int i=0; i<adjList.size();i++){
            for(int adj: adjList.get(i)){
                inDegree[adj]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<adjList.size(); i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        boolean[] safe = new boolean[adjList.size()];
        while(!q.isEmpty()){
            int top = q.peek();
            safe[top] = true; 
            q.poll();
            for(int adj: adjList.get(top)){
                inDegree[adj]--;
                if(inDegree[adj] == 0) q.add(adj);
            }
        }
        for(int i=0; i<adjList.size(); i++){
            if(safe[i]) res.add(i);
        }
        return res;
    }
}