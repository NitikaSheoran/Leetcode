class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0;
        int l2 = 0;
        while(l<s.length && l2<g.length){
            if(g[l2] <= s[l]){
                res++;
                l++;
                l2++;
            }else{
                l++;
            }
        }
        return res;
    }
}