class Solution {
    public String minWindow(String s, String t) {
        int l=0;
        int r=0;
        int count=0;
        int minLen = Integer.MAX_VALUE;
        int[] hash = new int[256];
        int n = s.length();
        int m = t.length();
        int stIdx=-1;
        for(int i=0; i<m; i++){
            hash[t.charAt(i)]++;
        }
        while(r<n){
            char ch = s.charAt(r);
            if(hash[ch]>0) count++;
            hash[ch]--;
            while(count == m){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    stIdx = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0) count--;
                l++;
            }
            r++;
        }
        return stIdx==-1? "": s.substring(stIdx, stIdx+minLen);
    }
}