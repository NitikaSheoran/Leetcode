class Solution {
    public String cAndS(int n){
        if(n == 1){
            return "1";
        }
        String prev = cAndS(n-1);
        String res = "";
        int i=0;
        while(i<prev.length()){
            int count=0;
            char ch = prev.charAt(i);
            while(i<prev.length() && prev.charAt(i) == ch){
                i++;
                count++;
            }
            res = res + count + ch;
        }
        return res;
    }
    public String countAndSay(int n) {
        String result = cAndS(n);
        return result;
    }
}