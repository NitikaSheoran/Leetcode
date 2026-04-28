class Solution {
    public int[] nextLargest(int[] prices){
        Stack<Integer> stack = new Stack<>();
        int n = prices.length;
        int[] res = new int[n];
        res[n-1] = n;
        stack.push(n-1);
        int l = n-2;
        while(!stack.isEmpty() && l>=0){
            int top = stack.peek();
            while(!stack.isEmpty() && prices[stack.peek()]<prices[l]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[l] = n;
                stack.push(l);
            }else{
                res[l] = stack.peek();
            }
        
            l--;
        }
        return res;
    }
    public int maxProfit(int[] prices) {
        int[] nextL = nextLargest(prices);
        int n = prices.length;
        int maxP = 0;
        for(int i=0; i<n; i++){
            if(nextL[i] != n)
                maxP = Math.max(prices[nextL[i]]-prices[i], maxP);
        }
        return maxP;
    }
}