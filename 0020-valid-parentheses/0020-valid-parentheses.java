class Solution {
    public boolean isOpen(char ch){
        return ch == '(' || ch == '[' || ch == '{';
    }
    public char close(char ch){
        if(ch == ')') return '(';
        if(ch == ']') return '[';
        if(ch == '}') return '{';
        return '#';
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(isOpen(ch)){
                stack.push(ch);
            }else{
                if(stack.isEmpty() || stack.peek() != close(ch)){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}