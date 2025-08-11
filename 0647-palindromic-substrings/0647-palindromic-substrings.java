class Solution {
    public boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<=i; j++){
                String sub = s.substring(j, i+1);
                if(isPalindrome(sub)){
                    count++;
                }
            }
        }

        return count;
    }
}