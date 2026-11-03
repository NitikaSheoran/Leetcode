class Solution {
    public int maxProfit(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i=0; i<prices.length; i++){
            while(i<prices.length && !stack.isEmpty() && stack.peek()<prices[i]){
                res += (prices[i] - stack.pop());
                stack.push(prices[i]);
            }
            if(i<prices.length){
                stack.push(prices[i]);
            }

        }
        return res;
    }
}