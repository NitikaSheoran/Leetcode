class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int n = stones.length;
        for(int i=0; i<n; i++){
            pq.add(stones[i]);
        }
        while(pq.size()>1){
            int s1 = pq.poll();
            int s2 = pq.poll();
            if(s1>s2){
                pq.add(s1-s2);
            }
        }
        if(pq.size()==1){
            return pq.poll();
        }
        return 0;
    }
}