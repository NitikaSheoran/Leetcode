class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        // if(n==1 && m==1 && matrix[0][0])
        int l = 0;
        int r = n-1;
        int idx=0;
        while(l<=r){
            int mid = (l+r)/2;
            if(matrix[mid][0] == target) return true;
            if(matrix[mid][0] < target && matrix[mid][m-1]>target) break;
            if(matrix[mid][0] > target){
                r = mid-1;
            }else{
                // idx = mid;
                l = mid+1;
            }
        }
        idx = (l+r)/2;
        for(int i=0; i<m; i++){
            if(matrix[idx][i] == target) return true;
        }
        return false;
    }
}