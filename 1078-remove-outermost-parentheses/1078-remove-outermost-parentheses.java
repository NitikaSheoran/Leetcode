class Solution {
    public String removeOuterParentheses(String s) {
        int open = 0;
        int close = 0;
        String res = "";
        int start = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                open++;
            }
            if(s.charAt(i) == ')'){
                close++;
            }
            if(open == close){
                res += s.substring(start+1,i);
                open = 0;
                close = 0;
                start = i+1;
            }
        }
        return res;
    }
}