class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 1 && matrix[0].length == 1 && matrix[0][0] == target){
            return true;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int l=0;
        int r = m-1;
        int row = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(matrix[mid][0] > target){
                r = mid-1;
            }else{
                row=mid;
                l=mid+1;
            }
        }
        if(row==-1){
            row=l;
        }
        int high=n-1;
        int low=0;
        while(low<=high){
            int mid = (low+high)/2;
            if(matrix[row][mid] > target){
                high = mid-1;
            }else if(matrix[row][mid] == target){
                return true;
            }else{
                low=mid+1;
            }
        }
        return false;
    }
}