class Solution {
    public boolean change(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        int n = s1.length();
        int count=0;
        for(int i=0; i<n; i++){
            if(s1.charAt(i) != s2.charAt(i)) count++;
            if(count>1) return false;
        }
        return true;
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        if(startGene.equals(endGene)) return 0;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int dest=-1;
        int n = bank.length;
        for(int i=0; i<bank.length+1; i++){
            if(i<n && endGene.equals(bank[i])) dest = i+1;
            adjList.add(new ArrayList<>());
        }

        if(dest == -1) return -1;
        for(int i=0; i<n; i++){
            if(change(startGene, bank[i])) adjList.get(0).add(i+1);
        }

        for(int i=0; i<n; i++){
            String start = bank[i];
            for(int j=0; j<n; j++){
                if(i!=j && change(start, bank[j])) adjList.get(i+1).add(j+1);
            }
        }

        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int top = q.poll();
                if(top == dest) return count;

                for(int adj: adjList.get(top)){
                    if(!visited[adj]){
                        visited[adj] = true;
                        q.add(adj);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}