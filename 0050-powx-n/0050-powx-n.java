class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        long exp = n;
        if(exp < 0){
            x = 1/x;
            exp = -exp;
        }

        double res = myPow(x, (int)(exp>>1));
        if(exp%2 == 0){
            return res*res;
        }else{
            return res*res*x;
        }
    }
}