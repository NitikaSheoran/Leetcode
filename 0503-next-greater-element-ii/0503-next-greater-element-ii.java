class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[nums.length];
        res[n-1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[n-1]);
        for(int i= 2*n-1; i>=0; i--){
            int num = nums[i%n];
            while(!stack.isEmpty() && stack.peek() <= num){
                stack.pop();
            }
            if(!stack.isEmpty()){
                res[i%n] = stack.peek();
            }else{
                res[i%n] = -1;
            }
            stack.push(nums[i%n]);
        }
        
        return res;
    }
}