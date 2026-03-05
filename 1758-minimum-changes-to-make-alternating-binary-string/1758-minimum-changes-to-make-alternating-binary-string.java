class Solution {
    public int minOperations(String s) {
        int zero = 0;
        int one = 0;
        for(int i=0; i<s.length(); i++){
            if(i%2==0){
                if(s.charAt(i) == '0'){
                    one++;
                }
                else{
                    zero++;
                }
            }else{
                if(s.charAt(i) == '1'){
                    one++;
                }else{
                    zero++;
                }
            }
        }
        return Math.min(zero, one);
    }
}