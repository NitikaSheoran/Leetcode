class Solution {
    public int countOfSubarray(int[] nums, int goal){
        if(goal <0) return 0;
        int l=0;
        int r=0;
        int sum=0;
        int n = nums.length;
        int count=0;
        while(r<n){
            sum+=nums[r];
            while(sum>goal && l<=r){
                sum-=nums[l];
                l++;
            }
            count += r-l+1;
            r++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        // HashMap<Integer,Integer> map = new HashMap<>();
        // int n = nums.length;
        // int count=0;
        // int sum=0;
        // map.put(0,1);
        // for(int i=0; i<n; i++){
        //     sum += nums[i];
        //     if(map.containsKey(sum - goal)){
        //         count += map.get(sum - goal);
        //     }
        //     map.put(sum, map.getOrDefault(sum,0)+1);
        // }
        // return count;
        int x = countOfSubarray(nums, goal);
        int y = countOfSubarray(nums, goal-1);
        return x-y;
        
    }
    
}