class Solution {
    public long countValidSubstrings(String s) {
        long res = 0;
        int n = s.length();
        int l = 0;
        for(int i=0; i<n; i++){
            if(i>=2 && s.charAt(i)=='c' && s.charAt(i-1)=='b' && s.charAt(i-2)=='a'){
                l = Math.max(l, i-1);
            }
            res += i-l+1;
        }
        return res;
    }
}