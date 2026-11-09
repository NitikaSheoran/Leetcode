class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;
        int n = s.length();
        int m = t.length();
        int l = 0;
        int r = 0;
        while(l<n && r<m){
            if(s.charAt(l) == t.charAt(r)){
                l++;
            }
            r++;
        }
        return l==s.length();
    }
}