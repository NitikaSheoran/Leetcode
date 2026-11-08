class Solution {
    public long countValidSubstrings(String s) {
        int a=-1;
        int b=-1;
        int c=-1;
        int n = s.length();
        int l = 0;
        long res = 0;
        for(int r=0; r<n; r++){
            if(s.charAt(r) == 'a'){
                a=r;
            }else if(s.charAt(r) == 'b' && a!=-1){
                b = a;
            }else if(s.charAt(r) == 'c' && b!=-1){
                c = b;
            }
            if(c!=-1){
                l = Math.max(l, c+1);
            }
            res += r-l+1;
        }
        return res;
    }
}