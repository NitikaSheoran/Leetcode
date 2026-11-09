class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n-1;
        int maxArea = Integer.MIN_VALUE;
        int area = 0;

        while(l<r){
            area = (r-l)*(Math.min(height[l], height[r]));
            maxArea = Math.max(area, maxArea);

            if(height[l] > height[r]){
                r--;
            }else{
                l++;
            }
        }
        return maxArea;
    }
}