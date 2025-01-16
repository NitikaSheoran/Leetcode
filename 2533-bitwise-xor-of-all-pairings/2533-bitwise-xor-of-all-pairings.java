class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int xor1=0; 
        int xor2=0;
        if(n%2 == 0){
            xor2 = 0;
        }else{
            for(int i=0; i<m; i++){
                xor2 ^= nums2[i];
            }
        }

        if(m%2 == 0){
            xor1 = 0;
        }else{
            for(int i=0; i<n; i++){
                xor1 ^= nums1[i];
            }
        }   

        return xor1^xor2;  
    }
}