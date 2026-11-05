class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res=0;
        for(int i=arr1.length-1; i>=0; i--){
            int num = arr1[i];
            boolean found = true;
            for(int j=arr2.length-1; j>=0; j--){
                if(Math.abs(num-arr2[j]) <= d){
                    found=false;
                    break;
                }
            }
            if(found) res++;
        }
        return res;
    }
}