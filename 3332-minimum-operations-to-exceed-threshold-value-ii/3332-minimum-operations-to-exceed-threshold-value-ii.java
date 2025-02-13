class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<Long>(Arrays.stream(nums)
                .mapToLong(i -> (long) i)
                .boxed()
                .collect(Collectors.toList()));
        int count=0;
        while(!pq.isEmpty() && pq.peek()<k){
            if(pq.size() < 2){
                return count;
            }
            long x = pq.poll();
            long y = pq.poll();
            long res = x*2 + y;
            pq.add(res);
            count++;
        }
        return count;
    }
}