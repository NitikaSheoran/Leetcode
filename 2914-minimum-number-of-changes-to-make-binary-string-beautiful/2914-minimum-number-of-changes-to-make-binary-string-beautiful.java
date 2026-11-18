class Solution {
    public int minChanges(String s) {
        int n = s.length();
        int i = 0;
        int j = 1;
        int res = 0;
        while(i<j && j<n){
            if(s.charAt(i) != s.charAt(j)){
                res++;
            }
            i+=2;
            j+=2;
        }
        return res;
    }
}