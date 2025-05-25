class Solution {
    public static int count = 0;
    public void count(int[] nums, int low, int mid, int high){
        int l = low;
        int r = mid+1;
        for(int i=l; i<=mid; i++){
            while(r<=high && (long) nums[i] > 2L * nums[r]){
                r++;
            }
            count += (r - (mid + 1));
        }
    }
    public void merge(int[] nums, int low, int mid, int high){
        int[] left = new int[mid-low+1];
        int[] right = new int[high-mid];
        int a = 0;
        for(int i=low; i<=mid; i++){
            left[a] = nums[i];
            a++;
        }
        a=0;
        for(int i=mid+1; i<=high; i++){
            right[a] = nums[i];
            a++;
        }
        int lSize = mid-low+1;
        int rSize = high-mid;
        int l=0;
        int r = 0;
        int k = low;
        while(l<lSize && r<rSize){
            if(left[l] <= right[r]){
                nums[k] = left[l];
                l++;
                k++;
            }else{
                nums[k] = right[r];
                r++;
                k++;
            }
        }
        while(l<lSize){
            nums[k] = left[l];
            l++;
            k++;
        }
        while(r<rSize){
            nums[k] = right[r];
            k++;
            r++;
        }
    }
    public void mergeSort(int[] nums, int low, int high){
        if(low< high){
            int mid = (low+high)/2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid+1, high);
            count(nums, low, mid, high);
            merge(nums, low, mid, high);
        }
    }
    public int reversePairs(int[] nums) {
        count=0;
        mergeSort(nums, 0, nums.length-1);
        return count;
    }
}