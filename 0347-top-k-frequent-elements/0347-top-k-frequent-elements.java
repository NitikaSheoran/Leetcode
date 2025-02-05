class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        map.forEach((key, value)-> pq.add(new int[]{key, value}));
        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = pq.poll()[0];
        }
        return res;
    }
}