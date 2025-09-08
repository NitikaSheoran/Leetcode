class Solution {
    public boolean isValid(int num){
        while(num!=0){
            int temp = num%10;
            if(temp == 0) return false;
            num = num/10;
        }
        return true;
    }
    public int[] getNoZeroIntegers(int n) {
        int[] res = new int[2];
        int num1 = 1;
        while(num1<n){
            int num2 = n-num1;
            if(isValid(num1) && isValid(num2)){
                res[0] = num1;
                res[1] = num2;
                return res;
            }else{
                num1++;
            }
        }
        return res;
    }
}