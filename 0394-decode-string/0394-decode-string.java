class Solution {
    public String decodeString(String s) {
        Stack<Integer> s1 = new Stack<>();
        Stack<StringBuilder> s2 = new Stack<>();
        StringBuilder res = new StringBuilder();
        int num=0;
        for(char ch: s.toCharArray()){
            if(ch >= '0' && ch<='9'){
                num = num*10 + ch-'0';
            }else if(ch == '['){
                s2.push(res);
                res = new StringBuilder();
                s1.push(num);
                num=0;
            }else if(ch==']'){
                StringBuilder temp = res;
                res = s2.pop();
                int count = s1.pop();
                while(count-->0){
                    res.append(temp);
                }
            }else{
                res.append(ch);
            }
        }
        return res.toString();
    }
}