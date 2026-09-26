class Solution {
    public String addBinary(String a, String b) {
        int n1 = a.length()-1;
        int n2 = b.length()-1;
        int carry = 0;
        String res = "";

        while(n1 >= 0 || n2 >= 0 || carry > 0){
            char c1 = '0';
            char c2 = '0';
            if(n1 >= 0){
                c1 = a.charAt(n1);
                n1--;
            }
            if(n2 >= 0){
                c2 = b.charAt(n2);
                n2--;
            }

            int x = c1 - '0';
            int y = c2 - '0';

            res = (x+y+carry)%2 + res;
            carry = (x+y+carry)/2;
        }
        return res;
    }
}