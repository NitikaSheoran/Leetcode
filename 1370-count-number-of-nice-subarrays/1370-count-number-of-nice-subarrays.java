class Solution {
    public int countSub(int[] nums, int k){
        if(k<0) return 0;
        int n = nums.length;
        int l=0;
        int r=0;
        int count=0;
        int odd=0;
        while(r<n){
            int num = nums[r];
            if(num%2 == 1) odd++;
            while(odd > k){
                if(nums[l]%2 == 1) odd--;
                l++;
            }
            count += (r-l+1);
            r++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return countSub(nums, k)-countSub(nums, k-1);
    }
}