class Solution {
    static int mod = (int)(1e9 + 7);
    public int[] lse(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<arr.length; i++){
            int num = arr[i];
            while(!stack.isEmpty() && arr[stack.peek()]>num){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1: stack.peek();
            stack.push(i);
        }
        return res;
    }
    public int[] rse(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? n: stack.peek();
            stack.push(i);
        }
        return res;
    }
    public int sumSubarrayMins(int[] arr) {
        int[] lse = lse(arr);
        int[] rse = rse(arr);
        long res = 0;
        int n = arr.length;
        for(int i=0; i<n; i++){
            long left = i - lse[i];
            long right = rse[i] - i;
            long prod = (left * right) % mod;
            prod = (prod * arr[i]) % mod;
            res = (res + prod) % mod;
        }
        return (int)res;
    }
}