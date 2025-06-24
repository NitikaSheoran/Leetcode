class Solution {
    public int maxProfit(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int top = 0;
        int res = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            while(i<n && !stack.isEmpty() && stack.peek() < nums[i]){
                res += (nums[i] - stack.pop());
                stack.push(nums[i]);
                i++;
            }
            if(i<n) stack.push(nums[i]);
        }
        return res;
    }
}