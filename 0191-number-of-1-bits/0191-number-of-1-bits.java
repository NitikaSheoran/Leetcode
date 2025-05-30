class Solution {
    public int hammingWeight(int n) {
        if(n==0) return 0;
        int count = 0;
        int binary = n;
        while(binary > 0){
            binary &= (binary-1);
            count++;
        }
        return count;
    }

}