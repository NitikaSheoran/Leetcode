class Solution {
    public int[] rse(int[] nums){
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? n: stack.peek();
            stack.push(i);
        }
        return res;
    }
    public int[] lse(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        int n = nums.length;
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty()? -1: stack.peek();
            stack.push(i);
        }
        return res;

    }
    public long subMin(int[] nums){
        int[] lse = lse(nums);
        int[] rse = rse(nums);
        int n = nums.length;
        long res = 0;
        for(int i=0; i<n; i++){
            long left = i - lse[i];
            long right = rse[i] - i;
            res += left * right * (long)nums[i];
        }
        return res;
    }
    public int[] lge(int[] nums){
        int[] res = new int[nums.length];
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty()? -1: stack.peek();
            stack.push(i);
        }
        return res;
    }
    public int[] rge(int[] nums){
        int[] res = new int[nums.length];
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty()? n: stack.peek();
            stack.push(i);
        }
        return res;
    }
    public long subMax(int[] nums){
        int[] lge = lge(nums);
        int[] rge = rge(nums);
        int n = nums.length;
        long res = 0;
        for(int i = 0; i < n; i++){
            long left = i - lge[i];
            long right = rge[i] - i;
            res += left * right * (long)nums[i];
        }
        return res;
    }
    public long subArrayRanges(int[] nums) {
        return subMax(nums) - subMin(nums);
    }
}