class Solution {
    public void releaseServer(PriorityQueue<int[]> unavail, PriorityQueue<int[]> avail, int[] servers, int t){
        while(!unavail.isEmpty() && unavail.peek()[0]<=t){
            int[] top = unavail.poll();
            avail.offer(new int[]{servers[top[1]], top[1]});
            
        }
    }
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = tasks.length;
        int[] res = new int[n];

        PriorityQueue<int[]> avail = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];

            return a[0]-b[0];
        });

        PriorityQueue<int[]> unavail = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        int idx=0;
        for(int server: servers){
            avail.add(new int[]{server,idx});
            idx++;
        }
        
        int t=0;
        for(int i=0; i<tasks.length; i++){
            int time = tasks[i];
            t = Math.max(t, i);
            releaseServer(unavail, avail, servers, t);
            if(avail.isEmpty()){
                t = unavail.peek()[0];
                releaseServer(unavail, avail, servers, t);
            }

            int[] server = avail.poll();
            int index = server[1];
            res[i] = index;
            unavail.offer(new int[]{t+tasks[i], index});
        }

        return res;
    }
}