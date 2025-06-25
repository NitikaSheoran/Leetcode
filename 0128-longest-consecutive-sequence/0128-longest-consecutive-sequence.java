class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }

        int cnt = 1;
        int longestC = 0;
        for(int num: set){
            if(!set.contains(num-1)){
                int x = num;
                cnt = 1;
                while(set.contains(x+1)){
                    x++;
                    cnt++;
                }
                longestC = Math.max(longestC, cnt);
            }
        }
        return longestC;
    }
}