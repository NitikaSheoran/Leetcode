class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int row = 1; row<=numRows; row++){
            List<Integer> temp = new ArrayList<>();
            int ans = 1;
            temp.add(1);
            for(int col = 1; col<row; col++){
                ans = ans*(row-col);
                ans = ans/col;
                temp.add(ans);
            }
            res.add(temp);
        }
        return res;
    }
}