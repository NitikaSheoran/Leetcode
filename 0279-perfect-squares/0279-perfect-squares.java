class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int level = 0;
        q.add(n);
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i=0; i<size; i++){
                int num = q.poll();
                for(int j=1; j*j<=num; j++){
                    int next = num-j*j;
                    if(next == 0) return level;
                    if(!visited.contains(next)){
                        visited.add(next);
                        q.add(next);
                    }
                }
            }
        }
        return level;
    }
}