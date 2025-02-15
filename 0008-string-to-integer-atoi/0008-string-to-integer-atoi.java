class Solution {
    public long atoi(String s, int i, long sum, int sign){
        if(i==s.length()){
            return sum*sign;
        }
        if(Character.isDigit(s.charAt(i))){
            sum = sum*10 + (s.charAt(i)-'0');
            if(sum>Integer.MAX_VALUE){
                return sign==1? Integer.MAX_VALUE: Integer.MIN_VALUE;
            }
            return atoi(s,i+1,sum,sign);
        }else{
            return sum*sign;
        }
    }
    public int myAtoi(String s) {
        s=s.trim();
        int i=0;
        int sign=1;
        if(s.length()==0){
            return 0;
        }
        if(s.charAt(0)=='-'){
            sign=-1;
            i++;
        }else if(s.charAt(0)=='+'){
            i++;
        }
        long sum=0;
        long res=atoi(s,i,sum,sign);
        return (int)res;
    }
}