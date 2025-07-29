class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] res= new int[n];
        Arrays.fill(res, 1);

        // for(int i=0; i<n; i++){
        //     int or = 0;
        //     int maxOr = Integer.MIN_VALUE;
        //     int maxLen = 0;
        //     for(int j=i; j<n; j++){
        //         or = or | nums[j];
        //         if(or > maxOr){
        //             maxOr = or;
        //             maxLen = j-i+1;
        //         }
        //     }
        //     res[i] = maxLen;
        // }
        int[] pos = new int[31];
        Arrays.fill(pos, -1);
        for(int i=n-1; i>=0; i--){
            int j = i;
            for(int bit = 0; bit<31; bit++){
                if((nums[i] & (1<<bit)) == 0){
                    if(pos[bit] != -1){
                        j = Math.max(j, pos[bit]);
                    }
                }else{
                    pos[bit] = i;
                }
            }

            res[i] = j-i+1;
        }
        return res;
    }
}