class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLowerCase(ch)){
                stack.push(ch);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
        s="";
        while(!stack.isEmpty()){
            s = stack.pop() + s;
        }
        return s;
    }
}