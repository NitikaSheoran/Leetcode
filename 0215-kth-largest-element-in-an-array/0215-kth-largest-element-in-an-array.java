class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1) return nums[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
        }
        for(int i=0; i<k-1; i++){
            pq.poll();
        }
        return pq.poll();
    }
}