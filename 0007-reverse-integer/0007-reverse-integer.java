class Solution {
    public int reverse(int x) {
        int temp = x;
        double num=0;
        while(temp!=0){
            int a = temp%10;
            num = num*10 + a;
            if(num>=Integer.MAX_VALUE || num<=Integer.MIN_VALUE){
                return 0;
            }
            temp = temp/10;
        }
        return (int)num;
        
    }
}