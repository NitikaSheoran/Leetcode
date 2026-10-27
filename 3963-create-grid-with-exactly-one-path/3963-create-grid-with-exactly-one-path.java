class Solution {
    public String[] createGrid(int m, int n) {
        char[][] res = new char[m][n];
        for(char[] row: res){
            Arrays.fill(row, '#');
        }
        for(int i=0; i<m; i++){
            res[i][0]='.';
        }
        for(int i=0; i<n; i++){
            res[m-1][i]='.';
        }
        String[] ans = new String[m];
        for(int i=0; i<m; i++){
            String str = "";
            for(int j=0; j<n; j++){
                str = str + res[i][j];
            }
            ans[i] = str;
        }
        return ans;
        
    }
}