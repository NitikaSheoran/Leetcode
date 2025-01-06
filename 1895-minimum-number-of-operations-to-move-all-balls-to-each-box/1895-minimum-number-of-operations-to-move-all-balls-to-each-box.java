class Solution {
    public int[] minOperations(String boxes) {
        int ballLeft = 0;
        int moveLeft = 0;
        int ballRight = 0;
        int moveRight = 0;
        int n = boxes.length();
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            ans[i] += moveLeft;
            ballLeft += Character.getNumericValue(boxes.charAt(i));
            moveLeft += ballLeft;

            int j = n-i-1;
            ans[j] += moveRight;
            ballRight += Character.getNumericValue(boxes.charAt(j));
            moveRight += ballRight;
        }
        return ans;
    }
}