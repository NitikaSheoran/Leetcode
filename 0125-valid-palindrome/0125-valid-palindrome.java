class Solution {
    public boolean isAlpha(char ch){
        return Character.isLetterOrDigit(ch);
    }
    public boolean isPalindrome(String s) {
        int i=0;
        String s2 = "";
        for(i=0; i<s.length(); i++){
            if(isAlpha(s.charAt(i))){
                s2 += Character.toLowerCase(s.charAt(i));
            }
        }
        i=0;
        int j = s2.length()-1;
        while(i<j){
            if(s2.charAt(i) == s2.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }

        return true;
    }
}