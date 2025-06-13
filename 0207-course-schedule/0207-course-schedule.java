class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            int[] arr = prerequisites[i];
            adjList.get(arr[0]).add(arr[1]);
        }

        for(int i=0; i<adjList.size(); i++){
            for(int adj: adjList.get(i)){
                inDegree[adj]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        int res=0;
        while(!q.isEmpty()){
            int top = q.peek();
            res++;
            q.poll();
            for(int adj: adjList.get(top)){
                inDegree[adj]--;
                if(inDegree[adj] == 0) q.add(adj);
            }
        }
        return res == numCourses;
    }
}