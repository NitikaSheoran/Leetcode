class Solution {
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");

        int n = Math.min(nums1.length, nums2.length);
        // System.out.println(n);
        int i=0;
        for(i=0; i<n; i++){
            String num1 = nums1[i];
            String num2 = nums2[i];
            int n1 = Integer.valueOf(num1);
            int n2 = Integer.valueOf(num2);
            // System.out.println(n1 + "  " + n2);
            if(n1 > n2) return 1;
            if(n1 < n2) return -1;
        }
        while(nums1.length > nums2.length && i<nums1.length){
            int n1 = Integer.valueOf(nums1[i]);
            // System.out.println(n1);
            if(n1 > 0) return 1;
            if(n1 < 0) return -1;
            i++;
        }
        while(nums1.length < nums2.length && i<nums2.length){
            int n1 = Integer.valueOf(nums2[i]);
            if(n1 > 0) return -1;
            if(n1 < 0) return 1;
            i++;
        }
        return 0;
    }
}