class Solution {
    public long countGood(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        int n = nums.length;
        int l = 0, r = 0;
        int pairs = 0;
        while(r < n){
            pairs += map.getOrDefault(nums[r],0);
            map.put(nums[r], map.getOrDefault(nums[r],0)+1);
            while(pairs >= k){
                ans += n-r;
                map.put(nums[l], map.get(nums[l])-1);
                pairs -= map.get(nums[l]);
                l++;
            }
            r++;
        }
        return ans;
    }
}
