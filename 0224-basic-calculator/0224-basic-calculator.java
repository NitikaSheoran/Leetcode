// class Solution {
//     public int calculate(String s) {
//         Stack<Character> operator = new Stack<>();
//         Stack<Integer> operand = new Stack<>();
        
//         // operator.push('(');
//         s = "(" + s + ")";
//         for(int i=0; i<s.length(); i++){
//             char ch = s.charAt(i);

//             if(ch == ' ') continue;

//             if(ch == '('){
//                 operator.push('(');
//             }else if(ch == ')'){
//                 while(operator.peek() != '('){
//                     int op1 = operand.pop();
//                     int op2 = operand.pop();
//                     char op = operator.pop();

//                     int res = op == '+' ? op1+op2 : op2-op1;
//                     operand.push(res);
//                 }
//                 operator.pop();
                
//             }else if(ch == '+' || ch == '-'){
//                 operator.push(ch);
//             }else{
//                 int num = 0;

//                 while(i<s.length() && Character.isDigit(s.charAt(i))){
//                     num = num*10 + (s.charAt(i) - '0');
//                     i++;
//                 }
//                 operand.push(num);
//                 i--;
//             }
//         }

//         return operand.pop();
//     }
// }


class Solution {
    public int calculate(String s) {
        int result = 0;
        int number = 0;
        int sign = 1; 
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + (s.charAt(i) - '0');
                    i++;
                }
                result += sign * number;
                i--; 
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                int prevSign = stack.pop();
                int prevResult = stack.pop();
                result = prevResult + prevSign * result;
            }
        }

        return result;
    }
}
