class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((x,y)->y[0]-x[0]);
        int n = nums.length;
        int[] res = new int[k];
        for(int i=0; i<n; i++){
            pq1.add(new int[]{nums[i], i});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->x[1]-y[1]);
        for(int i=0; i<k; i++){
            pq.add(pq1.poll());
        }
        for(int i=0; i<k; i++){
            int[] arr = pq.poll();
            res[i] = arr[0];
        }
        return res;
    }
}