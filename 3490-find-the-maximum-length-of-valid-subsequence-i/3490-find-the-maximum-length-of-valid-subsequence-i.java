
// recursion

// class Solution {
//     public void sub(int i, int[] nums, ArrayList<Integer> arr, int div, int[] max){
//         if(i == nums.length){
//             return;
//         }

//         if(arr.isEmpty() || (nums[i]+arr.get(arr.size()-1))%2== div){
//             System.out.println(arr.size());
//             arr.add(nums[i]);
//             max[0] = Math.max(max[0], arr.size());
//             sub(i+1, nums, arr, div, max);
//             arr.remove(arr.size() - 1); 
//         }
//         sub(i+1, nums, arr, div, max);
//     }
//     public int maximumLength(int[] nums) {
//         int n = nums.length;
//         int even = 0;
//         int odd = 0;
//         for(int i=0; i<n; i++){
//             int[] max = new int[1];
//             max[0] = 1;
//             ArrayList<Integer> arr = new ArrayList<>();
//             arr.add(nums[i]);
//             sub(i+1, nums, arr, 0, max);
//             even = Math.max(even, max[0]);

//             max[0] = 1;
//             ArrayList<Integer> arr2 = new ArrayList<>();
//             arr2.add(nums[i]);
//             sub(i+1, nums, arr2, 1, max);
//             odd = Math.max(odd, max[0]);
//         }
        

//         return Math.max(odd, even);
//     }
// }


// memo

// class Solution {
//     int[][][] dp;

//     public int dfs(int i, int lastIndex, int div, int[] nums) {
//         if (i == nums.length) return 0;

//         if (dp[i][lastIndex + 1][div] != -1) return dp[i][lastIndex + 1][div];
//         int notTake = dfs(i + 1, lastIndex, div, nums);
//         int take = 0;
//         if (lastIndex == -1 || (nums[i] + nums[lastIndex]) % 2 == div) {
//             take = 1 + dfs(i + 1, i, div, nums);
//         }

//         return dp[i][lastIndex + 1][div] = Math.max(take, notTake);
//     }

//     public int maximumLength(int[] nums) {
//         int n = nums.length;
//         dp = new int[n][n + 1][2]; 

//         for (int[][] row : dp)
//             for (int[] d : row)
//                 Arrays.fill(d, -1);

//         int maxEven = 0, maxOdd = 0;
//         for (int i = 0; i < n; i++) {
//             maxEven = Math.max(maxEven, 1 + dfs(i + 1, i, 0, nums));
//             maxOdd = Math.max(maxOdd, 1 + dfs(i + 1, i, 1, nums));
//         }

//         return Math.max(maxEven, maxOdd);
//     }
// }


// // tabulation
// class Solution {
//     public int maximumLength(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n][2]; 
                                    
//         for (int i = 0; i < n; i++) {
//             dp[i][0] = 1;
//             dp[i][1] = 1;
//         }

//         int maxLen = 1;

//         for (int i = 1; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 int sum = nums[i] + nums[j];
//                 int parity = sum % 2;
//                 if (dp[j][parity] + 1 > dp[i][parity]) {
//                     dp[i][parity] = dp[j][parity] + 1;
//                 }
//             }

//             maxLen = Math.max(maxLen, Math.max(dp[i][0], dp[i][1]));
//         }

//         return maxLen;
//     }
// }

class Solution {
    public int maximumLength(int[] nums) {
        int[] dp = new int[nums.length];
        int evens = 0;
        int odds = 0;
        int idxEven = -1;
        int idxOdd = -1;
        int res = 1;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        if ((nums[0] & 1) == 1) {
            odds = 1;
            idxOdd = 0;
        } else {
            evens = 1;
            idxEven = 0;
        }

        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                odds++;
                if (idxEven != -1) {
                    dp[i] = dp[idxEven] + 1;
                }
                idxOdd = i;
            } else {
                evens++;
                if (idxOdd != -1) {
                    dp[i] = dp[idxOdd] + 1;
                }
                idxEven = i;
            }

            int max = Math.max(evens, odds);
            res = Math.max(res, Math.max(max, dp[i]));
        }

        return res;
    }
}