class Solution {
    public Character opp(char ch){
        if(ch == '(') return ')';
        if(ch == '[') return ']';
        if(ch == '{') return '}';
        return '/';

    }
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        if(s.length() %2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        // stack.push(c.charAt(0));
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            char top = '.';
            if(!stack.isEmpty()){
                top = stack.peek();
            }
            if(opp(top) == ch){
                stack.pop();
            }else{
                stack.push(ch);
            }
            
        }
        return stack.size()==0 ? true : false;
    }
}