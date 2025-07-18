class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegree = new int[n];
        for(List<Integer> edge: edges){
            int u = edge.get(0);
            int v = edge.get(1);
            inDegree[v]++;
        }
        List<Integer> arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(inDegree[i] == 0){
                arr.add(i);
            }
        }

        return arr;
    }
}