class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int i=0;
        int n = s1.length();
        int count = 0;
        int idx1 = 0;
        int idx2 = 0;
        while(i<n){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
                if(count>2) return false;
                if(count == 1) idx1 = i;
                else idx2 = i;
            }
            i++;
        }
        if(count == 0) return true;
        if(count == 2){
            if(s1.charAt(idx1) == s2.charAt(idx2) && s1.charAt(idx2) == s2.charAt(idx1)){
                return true;
            }
        }
        return false;
    }
}