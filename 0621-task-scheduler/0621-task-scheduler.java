class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch: tasks){
            freq[ch-'A'] += 1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<26; i++){
            if(freq[i] > 0) pq.offer(freq[i]);
        }
        int time=0;
        while(!pq.isEmpty()){
            int cycle = n+1;
            List<Integer> restore = new ArrayList<>();
            int count = 0;
            while(cycle-- > 0 && !pq.isEmpty()){
                int currFreq = pq.poll();
                if(currFreq > 1){
                    restore.add(currFreq-1);
                }
                count++;
            }
            restore.forEach(pq::offer);
            time += (pq.isEmpty() ? count : n+1);
        }
        return time;
    }
}