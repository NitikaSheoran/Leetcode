class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prod = 1;
        int temp = n;
        while(n>0){
            int digit = n%10;
            sum += digit;
            prod *= digit;
            n = n/10;
        }

        return temp%(sum+prod) == 0;

    }
}