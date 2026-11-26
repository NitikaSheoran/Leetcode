class Solution {
    public int dig(int num, int digit){
        int count = 0;
        while(num != 0){
            int x = num%10;
            if(x==digit){
                count++;
            }
            num = num/10;
        }
        return count;
    }
    public int countDigitOccurrences(int[] nums, int digit) {
        int res = 0;
        for(int num: nums){
            res += dig(num, digit);
        }
        return res;
    }
}