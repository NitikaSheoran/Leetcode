class Solution {
    public int jump(int[] nums) {
        // int jumps = 0;
        // int l = 0;
        // int r = 0;
        // while(r<nums.length-1){
        //     int farthest = 0;
        //     for(int i=l; i<=r; i++){
        //         farthest = Math.max(farthest, i+nums[i]);
        //     }
        //     l=r+1;
        //     r=farthest;
        //     jumps+=1;
        // }
        // return jumps;

        int farthest = 0;
        int jumps = 0;
        int l=0;
        int r=0;
        int n=nums.length;
        while(r<n-1){
            farthest = 0;
            for(int i=l; i<=r; i++){
                farthest = Math.max(farthest, nums[i]+i);
            }
            l=r+1;
            r=farthest;
            jumps++;
        }
        return jumps;
    }
}