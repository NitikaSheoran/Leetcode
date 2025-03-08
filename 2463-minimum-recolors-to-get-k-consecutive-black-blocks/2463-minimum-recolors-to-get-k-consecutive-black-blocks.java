class Solution {

    public int minimumRecolors(String blocks, int k) {
        int l=0;
        int r=0;
        int n = blocks.length();
        int w = 0;
        int recolor = Integer.MAX_VALUE;
        while(r<n){
            if(blocks.charAt(r)=='W') w++;
            if(r-l+1 == k){
                recolor = Math.min(recolor, w);
                if(blocks.charAt(l)=='W'){
                    w--;
                }
                l++;
            }
            r++;
        }
        return recolor;
    }
}