class Solution {
    public int[] rightM(int[] height){
        int[] res = new int[height.length];
        res[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; i--){
            res[i] = Math.max(height[i], res[i+1]);
        }
        return res;
    }

    public int[] leftM(int[] height){
        int[] res = new int[height.length];
        res[0] = height[0];
        for(int i=1; i<height.length; i++){
            res[i] = Math.max(height[i], res[i-1]);
        }
        return res;
    }

    
    public int trap(int[] height) {
        int[] rM = rightM(height);
        int[] lM = leftM(height);

        int res = 0;
        for(int i=0; i<height.length; i++){
            res += Math.min(rM[i], lM[i])-height[i];
        } 
        return res;
    }
}