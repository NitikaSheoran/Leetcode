class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        long modificationCost = 0;
        for (int i = 0; i < arr.length; i++) {
            modificationCost += Math.abs(arr[i] - brr[i]); 
        }
        Arrays.sort(arr);
        Arrays.sort(brr);
        long Cost=0;
        for (int i = 0; i < arr.length; i++) {
            Cost += Math.abs(arr[i] - brr[i]); 
        }
        return Math.min(Cost+k,modificationCost);
    }
}