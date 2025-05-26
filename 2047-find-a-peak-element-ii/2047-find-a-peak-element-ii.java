class Solution {
    public int maxElement(int[][] mat, int col){
        int maxRow = 0;
        for (int i = 1; i < mat.length; i++) {
            if (mat[i][col] > mat[maxRow][col]) {
                maxRow = i;
            }
        }
        return maxRow;
    }
    public int[] findPeakGrid(int[][] mat) {
        int[] res = new int[2];
        int n = mat.length;
        int m = mat[0].length;
        int l = 0;
        int r = m-1;
        while(l<=r){
            int mid = (l+r)/2;
            int row = maxElement(mat, mid);
            int left = mid-1>=0 ? mat[row][mid-1] : -1;
            int right = mid+1<m ? mat[row][mid+1] : -1;
            if(mat[row][mid] > left && mat[row][mid] > right){
                res[0] = row;
                res[1] = mid;
                return res;
            }else if(mat[row][mid] < left){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        res[0] = -1;
        res[1] = -1;
        return res;
    }
}