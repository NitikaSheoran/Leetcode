class Solution {
    public int maxBalancedShipments(int[] weight) {
        int n = weight.length;
        int[] lge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && weight[stack.peek()]<=weight[i]){
                stack.pop();
            }
            lge[i] = stack.isEmpty()?i:stack.peek();
            stack.push(i);
        }

        int lastI = -1;
        int count = 0;
        for(int i=0; i<n; i++){
            if(lge[i]>lastI && lge[i]!=i){
                count++;
                lastI = i;
                // System.out.println(lastI + "  " + count);
            }
        }

        return count;
    }
}