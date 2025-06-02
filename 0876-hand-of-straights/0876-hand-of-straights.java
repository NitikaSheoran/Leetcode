class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize != 0) return false;
        if(groupSize == 1) return true;
        Map<Integer, Integer> map = new HashMap<>();
        int n = hand.length;
        for(int i=0; i<n; i++){
            map.put(hand[i] ,map.getOrDefault(hand[i],0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            if(!pq.contains(hand[i])){
                pq.add(hand[i]);
            }
        }
        while(!pq.isEmpty()){
            int smallest = pq.peek();
            for(int i=smallest; i<smallest+groupSize; i++){
                if(!map.containsKey(i)){
                    return false;
                }else{
                    map.put(i, map.get(i)-1);
                    if(map.get(i) <= 0){
                        map.remove(i);
                        if (i == pq.peek()) pq.poll();
                    }
                }
            }
        }
        return true;
        

    }
}