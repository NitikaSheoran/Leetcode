class Solution {
    public boolean canFinish(int n, int[][] prereq) {
        int[] inDegree = new int[n];
        for(int[] pre: prereq){
            int i = pre[0];
            int j = pre[1];
            inDegree[j]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        List<List<Integer>> adjL = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjL.add(new ArrayList<>());
        }
        for(int[] edge: prereq){
            int u = edge[0];
            int v = edge[1];
            adjL.get(u).add(v);
        }
        int count = 0;
        while(!q.isEmpty()){
            int top = q.poll();
            count++;
            for(int adj: adjL.get(top)){
                inDegree[adj]--;
                if(inDegree[adj] == 0) q.add(adj);
            }
        }
        return count == n;

    }
}