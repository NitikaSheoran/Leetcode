
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            int[] arr = prerequisites[i];
            adjList.get(arr[1]).add(arr[0]);
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
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int top = q.peek();
            res.add(top);
            q.poll();
            for(int adj: adjList.get(top)){
                inDegree[adj]--;
                if(inDegree[adj] == 0) q.add(adj);
            }
            
        }
        if (res.size() != numCourses) {
            return new int[0];
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}