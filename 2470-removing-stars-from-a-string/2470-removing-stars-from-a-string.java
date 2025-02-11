class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        String res="";
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch != '*'){
                stack.push(ch);
            }else{
                stack.pop();
            }
        }
        while(!stack.isEmpty()){
            res = stack.pop() + res;
        }
        return res;
    }
}