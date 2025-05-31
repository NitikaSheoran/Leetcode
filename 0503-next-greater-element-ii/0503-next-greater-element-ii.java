class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        int n = nums.length;
        res[n-1] = -1;
        for(int i=2*n-1; i>=0; i--){
            int num = nums[i%n];
            while(!stack.isEmpty() && stack.peek()<=num){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i%n] = -1;
            }else{
                res[i%n] = stack.peek();
            }
            stack.push(num);
        }
        
        return res;
    }
}