class Solution {
    public int[] lse(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1: stack.peek();
            stack.push(i);
        }
        return res;
    }
    public int[] rse(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? n: stack.peek();
            stack.push(i);
        }
        return res;
    }
    public int histo(int[] arr){
        int res = 0;
        int[] lse = lse(arr);
        int[] rse = rse(arr);
        for(int i=0; i<arr.length; i++){
            res = Math.max(res, (rse[i]-lse[i]-1)*arr[i]);
        }
        return res;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] histogram = new int[m];
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '1'){
                    histogram[j] += 1;
                } else {
                    histogram[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, histo(histogram));
        }
        return maxArea;
    }
}