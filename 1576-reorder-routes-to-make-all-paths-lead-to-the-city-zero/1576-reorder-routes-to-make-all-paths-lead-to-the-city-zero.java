class Solution {
    int count = 0;
    public void dfs(int node, int par, Map<Integer, List<List<Integer>>> map){
        if(!map.containsKey(node)) return;

        for(List<Integer> nei: map.get(node)){
            int neighbor = nei.get(0);
            int sign = nei.get(1);
            if(neighbor != par){
                count += sign;
                dfs(neighbor, node, map);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        for(int[] connection: connections){
            map.computeIfAbsent(connection[0], k->new ArrayList<List<Integer>>()).add(Arrays.asList(connection[1], 1));
            map.computeIfAbsent(connection[1], k->new ArrayList<List<Integer>>()).add(Arrays.asList(connection[0], 0));
        }
        dfs(0, -1, map);
        return count;

    }
}