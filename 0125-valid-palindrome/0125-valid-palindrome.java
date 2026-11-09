class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int n = s.length();
        int r = n-1;
        while(l<r){
            while(l<r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while(l<r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }

            char ch1 = l<n? Character.toLowerCase(s.charAt(l)): '.';
            char ch2 = r>=0? Character.toLowerCase(s.charAt(r)): '/';
            l++;
            r--;
            if(ch1 != ch2) return false;
        }
        return true;
    }

}