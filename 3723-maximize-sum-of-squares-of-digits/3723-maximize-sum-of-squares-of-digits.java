class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > 9*num) return "";
        int r = sum%9;
        StringBuilder res = new StringBuilder();
        int nines = sum/9;
        for(int i=0; i<nines; i++){
            res.append("9");
        }
        if(r>0){
            res.append((char)('0'+r));
        }
        int zeros = num-res.length();
        for(int i=0; i<zeros; i++){
            res.append('0');
        }
        return res.toString();
    }
}