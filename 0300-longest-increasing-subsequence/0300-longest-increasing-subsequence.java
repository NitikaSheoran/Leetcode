class Solution {
    int max;
    // public void f(int[] nums, int i, ArrayList<Integer> arr){
        
    //     if(i == nums.length){
    //         max = Math.max(max, arr.size());
    //         System.out.println(arr);
    //         return;
    //     }
        
    //     if(arr.size()==0 || nums[i] > arr.get(arr.size()-1)){
    //         arr.add(nums[i]);
    //         f(nums, i+1, arr);
        
    //         arr.remove(arr.size()-1);
    //     }
    //     f(nums, i+1, arr);
    // }

    public int f(int[] nums, int i, int prevIdx, int[][] dp){
        if(i == nums.length) return 0;

        if(dp[i][prevIdx+1] != -1) return dp[i][prevIdx+1];

        int take = 0;
        if(prevIdx == -1 || nums[i] > nums[prevIdx]){
            take = 1+f(nums, i+1, i, dp);
        }
        
        int notTake = 0+f(nums, i+1, prevIdx, dp);

        return dp[i][prevIdx+1] = Math.max(take, notTake);


    }
    public int lengthOfLIS(int[] nums) {
        // max = Integer.MIN_VALUE;
        int n = nums.length;
        // ArrayList<Integer> arr = new ArrayList<>();
        // f(nums, 0, arr);
        // return max;

        int[][] dp = new int[n][n+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(nums, 0, -1, dp);

        
        
        
    }
}