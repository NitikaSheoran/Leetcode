class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        long res=Integer.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[][] arr = new int[nums1.length][2];
        for(int i=0; i<nums1.length; i++){
            arr[i][1] = nums1[i];
            arr[i][0] = nums2[i];
        }
        Arrays.sort(arr, (a,b)->b[0]-a[0]);
        long topKsum = 0;
        for(int i=0; i<k; i++){
            topKsum += arr[i][1];
            pq.add(arr[i][1]);
        }
        res = topKsum*arr[k-1][0];
        for(int i=k; i<nums1.length; i++){
            topKsum += arr[i][1]-pq.poll();
            pq.add(arr[i][1]);
            res = Math.max(res, topKsum*arr[i][0]);
        }
        return res;
    }
}