class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i = n-1;
        while(i>=0 && digits[i] == 9){
            digits[i]=0;
            i--;
        }
        
        if(i == -1){
            int[] res = new int[n+1];
            res[0] = 1;
            for(int j=1; j<n+1; j++) res[j] = 0;
            return res;
        }

        digits[i] = digits[i]+1;
        return digits;
        
    }
}