class Solution {
    public boolean isOperator(String str){
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int i=0;
        int n=tokens.length;
        while(i<n){
            String str = tokens[i];
            if(!isOperator(str)){
                int num = Integer.valueOf(str);
                stack.push(num);
            }else{
                int n1 = stack.pop();
                int n2 = stack.pop();

                if(str.equals("+")){
                    stack.push(n1+n2);
                }else if(str.equals("-")){
                    stack.push(n2-n1);
                }else if(str.equals("*")){
                    stack.push(n2*n1);
                }else{
                    stack.push(n2/n1);
                }
            }
            i++;
        }
        return stack.pop();
    }
}