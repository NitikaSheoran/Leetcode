class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int x=0;
        for(int i=0; i<gain.length; i++){
            x+=gain[i];
            max = Math.max(max,x);
        }
        return max;
    }
}