class Solution {
    public int gcd(int num1, int num2) {
        if(num2 == 0) return num1;
        return gcd(num2, num1%num2);
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] mx = new int[n];
        int prefixM = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            prefixM = Math.max(prefixM, nums[i]);
            mx[i] = prefixM;
        }
        int[] pgcd = new int[n];
        for(int i=0; i<n; i++){
            pgcd[i] = gcd(nums[i], mx[i]);
        }
        Arrays.sort(pgcd);
        long res = 0;
        int l = 0;
        int r = n-1;
        while(l<r){
            res += gcd(pgcd[l], pgcd[r]);
            ++l;
            --r;
        }
        return res;
    }
}