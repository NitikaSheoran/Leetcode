class Solution {
    public boolean differ(String s1, String s2){
        int i=0;
        int j=0;
        int count = 0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i) != s2.charAt(j)){
                count++;
            }
            if(count > 1){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
    public int bfs(ArrayList<ArrayList<Integer>> adjList, int source, int dest){
        int res = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[adjList.size()];
        visited[0] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int node = q.poll();
                if(node == dest){
                    return res;
                }
                for(int adj: adjList.get(node)){
                    if(!visited[adj]){
                        visited[adj] = true;
                        q.offer(adj);
                    }
                }
            }
            res++;
        }
        return 0;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        if(!wordList.contains(endWord)) return 0;

        String current = beginWord;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int dest = -1;
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
            if(i<n && wordList.get(i).equals(endWord)) dest = i+1;
        }
        for(int i=0; i<n; i++){
            if(differ(beginWord, wordList.get(i))){
                adjList.get(0).add(i+1);
            }
        }
        if(adjList.get(0).size() == 0) return 0;
        for(int i=1; i<=n; i++){
            for(int j=i+1; j<=n; j++){
                String s1 = wordList.get(i-1);
                String s2 = wordList.get(j-1);
                if(differ(s1, s2)){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int res = bfs(adjList, 0, dest);
        return res;
    }
}