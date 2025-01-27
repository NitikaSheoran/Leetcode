class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftSmallest = new int[n];
        int[] rightSmallest = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            leftSmallest[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            rightSmallest[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int maxArea = 0;
        int area = 0;
        for(int i=0; i<n; i++){
            area = heights[i]*(rightSmallest[i] - leftSmallest[i] -1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}