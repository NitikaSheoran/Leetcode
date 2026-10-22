class Solution {
    public boolean isInc(int[] nums, int idx){
        int n = nums.length;
        int x = n-1;
        for(int i=idx+1; i<n; i++){
            if(nums[i] != x){
                return false;
            }
            x--;
        }
        x=0;
        for(int i=idx; i>=0; i--){
            if(nums[i] != x) return false;
            x++;
        }
        return true;
    }
    public boolean isDec(int[] nums, int idx){
        int x = 0;
        int n = nums.length;
        for(int i = idx; i<n; i++){
            if(nums[i] != x) return false;
            x++;
        }
        x = n-1;
        for(int i=idx-1; i>=0; i--){
            if(nums[i] != x) return false;
            x--;
        }
        return true;
    }
    public int minOperations(int[] nums) {
        // int zeroIdx = -1;
        int n = nums.length;
        if(n == 1) return 0;
        // for(int i=0; i<n; i++){
        //     if(nums[i] == 0){
        //         zeroIdx = i;
        //         break;
        //     }
        //  }
        // if(isInc(nums, zeroIdx)) return Math.min(zerIdx, n-zeroIdx+2);
        // if(isDec(nums, zeroIdx)) return Math.min(n-zeroIdx, zeroIdx+2);
        // return -1;
        int start = 0;
        for(int num: nums){
            if(num==0){
                break;
            }
            start++;
        }
        boolean asc = true;
        boolean desc = true;
        for(int i=1; i<n; i++){
            int val = nums[(start+i)%n];
            if(val != i) asc=false;
            if(val != n-i) desc=false;
            if(!asc && !desc) return -1;
        }
        if(asc){
            return Math.min(start, n-start+2);
        }
        return Math.min(n-start, start+2);
    }
}