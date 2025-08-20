class Solution {
    public int ncr(int n, int r){
        int res = 1;
        for(int i=0; i<r; i++){
            res = res*(n-i);
            res = res/(i+1);
        }
        return res;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for(int row = 0; row<numRows; row++){
            List<Integer> arr = new ArrayList<>();
            for(int col = 0; col<=row; col++){
                arr.add(ncr(row, col));
            }
            res.add(arr);
        }

        return res;
    }
}