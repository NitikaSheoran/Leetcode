class Solution {
    public int reverse(int x) {
        int temp = x;
        int num=0;
        while(temp!=0){
            int a = temp%10;
            if(num>Integer.MAX_VALUE/10 || (num==Integer.MAX_VALUE/10 && a>7)){
                return 0;
            }
            if(num<Integer.MIN_VALUE/10 || (num==Integer.MIN_VALUE/10 && a<-8)){
                return 0;
            }
            num = num*10 + a;
            temp = temp/10;
        }
        return num;
        
    }
}