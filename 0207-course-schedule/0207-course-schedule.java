class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            int[] prereq = prerequisites[i];
            adjList.get(prereq[0]).add(prereq[1]);
        }

        for(int i=0; i<adjList.size(); i++){
            for(int course: adjList.get(i)){
                inDegree[course]++;
            }
        }
        Queue<Integer> topo = new LinkedList<>();
        int res = 0;

        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 0){
                topo.add(i);
            }
        }
        while(!topo.isEmpty()){
            int top = topo.peek();
            res++;
            topo.poll();

            for(int adj: adjList.get(top)){
                inDegree[adj]--;
                if(inDegree[adj] == 0) topo.add(adj);
            }
        }

        return res == numCourses;
    }
}