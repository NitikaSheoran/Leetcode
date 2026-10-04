class Solution {
    public boolean checkValidString(String str) {
        Stack<Integer> s = new Stack<>();
        Stack<Integer> o = new Stack<>();
        int n = str.length();
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            if(ch == '('){
                o.push(i);
            }
            if(ch == '*'){
                s.push(i);
            }
            if(ch == ')'){
                if(!o.isEmpty()){
                    o.pop();
                }else if(!s.isEmpty()){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        while(!s.isEmpty() && !o.isEmpty()){
            if(s.peek() > o.peek()){
                s.pop();
                o.pop();
            }else{
                break;
            }
        }
        return o.isEmpty();
    }
}